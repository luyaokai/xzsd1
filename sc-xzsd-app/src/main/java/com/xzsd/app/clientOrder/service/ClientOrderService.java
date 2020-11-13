package com.xzsd.app.clientOrder.service;

import com.xzsd.app.clientOrder.dao.ClientOrderDao;
import com.xzsd.app.clientOrder.entity.*;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.AuthUtils;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-28
 */
@Service
public class ClientOrderService {

    @Resource
    private ClientOrderDao clientOrderDao;

    /**
     * clientOrder 新增订单
     * @param clientOrderInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(ClientOrderInfo clientOrderInfo) {
        List<String> listGoodsCode = Arrays.asList(clientOrderInfo.getGoodsCode().split(","));
        List<String> listGoodsCount = Arrays.asList(clientOrderInfo.getGoodsCount().split(","));
        List<String> listSellPrice = Arrays.asList(clientOrderInfo.getSellPrice().split(","));
        //订单商品种类数量
        clientOrderInfo.setOrderGoodsCount(listGoodsCount.size());
        //获取用户id
        String userId = AuthUtils.getCurrentUserId();
        clientOrderInfo.setUserId(userId);
        String orderCode = StringUtil.getCommonCode(2);
        clientOrderInfo.setOrderCode(orderCode);
        BigDecimal orderCost = new BigDecimal(0);
        //创建订单详情列表
        List<OrderDetailsInfo> orderList = new ArrayList<>();
        for (int i = 0; i < listGoodsCode.size(); i++){
            OrderDetailsInfo clientOrderInfo1 = new OrderDetailsInfo();
            clientOrderInfo1.setOrderCode(orderCode);
            clientOrderInfo1.setUserId(userId);
            clientOrderInfo1.setGoodsCode(listGoodsCode.get(i));
            clientOrderInfo1.setSellPrice(listSellPrice.get(i));
            clientOrderInfo1.setGoodsCount(listGoodsCount.get(i));
            BigDecimal sellPrice = new BigDecimal(listSellPrice.get(i));
            BigDecimal goodsCount = new BigDecimal(listGoodsCount.get(i));
            BigDecimal detailsCost = sellPrice.multiply(goodsCount);
            orderCost = orderCost.add(detailsCost);
            clientOrderInfo1.setOrderDetailsCost(detailsCost+"");
            orderList.add(clientOrderInfo1);
        }
        clientOrderInfo.setOrderCost(orderCost+"");
        int co = clientOrderDao.updateGoodsSum(orderList);
        if(0 == co){
            return AppResponse.bizError("库存不足");
        }
        //判断是否从购物车下单
        if(!"0".equals(clientOrderInfo.getCartCode())){
            List<String> listCartCode = Arrays.asList(clientOrderInfo.getCartCode().split(","));
            // 删除购物车
            int count = clientOrderDao.deleteShoppingCart(listCartCode);
            if(0 == count) {
                return AppResponse.bizError("删除失败，请重试！");
            }
        }
        int count = clientOrderDao.addOrder(clientOrderInfo);
        if(0 == count) {
            return AppResponse.bizError("购买失败！");
        }
        int count1 = clientOrderDao.addOrderDetails(orderList);
        if (orderList.size() != count1){
            return AppResponse.bizError("购买失败！");
        }
        return AppResponse.success("下单成功！");
    }

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-19
     */
    public AppResponse listOrder(OrderInfo orderInfo) {
        //获取用户id
        String userId = AuthUtils.getCurrentUserId();
        orderInfo.setUserId(userId);
        List<OrderInfo>  orderInfoList = clientOrderDao.listOrder(orderInfo);
        return AppResponse.success("查询成功！",orderInfoList);
    }

    /**
     * clientOrder 修改订单状态
     * @param orderInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-30
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(OrderInfo orderInfo) {
        //获取用户id
        String userId = AuthUtils.getCurrentUserId();
        orderInfo.setUserId(userId);
        // 修改订单状态
        int count = clientOrderDao.updateOrderState(orderInfo);
        if (0 == count) {
            return AppResponse.versionError("数据有变化，请刷新！");
        }else {
            //获取订单的商品数量和编号
            List<GoodsInfo> goodsInfoList = clientOrderDao.listGoods(orderInfo.getOrderCode());
            //取消订单
            if("4".equals(orderInfo.getOrderState())){
                //恢复库存
                int cou = clientOrderDao.recoverGoodsSum(goodsInfoList);
                if(0 == cou ){
                    return AppResponse.bizError("库存恢复失败");
                }
                return AppResponse.success("订单取消成功");
            }
            //确认收货
            if("2".equals(orderInfo.getOrderState())){
                //增加售量
                int cou = clientOrderDao.updateSellSum(goodsInfoList);
                if(0 == cou ){
                    return AppResponse.bizError("增加销量失败");
                }
                return AppResponse.success("确认收货成功");
            }
            return AppResponse.success("成功");
        }
    }

    /**
     * 查询订单详情列表
     * @param orderCode
     * @return
     * @Author cairuifeng
     * @Date 2020-04-30
     */
    public AppResponse listOrderDetails(String orderCode) {
        OrderInfo orderInfo= clientOrderDao.listOrderDetails(orderCode);
        return AppResponse.success("查询成功！",orderInfo);
    }

    /**
     * clientOrder 查询商品详情
     * @param orderCode
     * @return
     * @Author cairuifeng
     * @Date 2020-04-30
     */
    public AppResponse listGoodsForEvaluate(String orderCode) {
        List<GoodsInfo> goodsInfoList = clientOrderDao.listGoodsForEvaluate(orderCode);
        return AppResponse.success("查询成功！", goodsInfoList);
    }

    /**
     * clientOrder 新增订单
     * @param evaluateInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-05-02
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoodsEvaluate(EvaluateInfo evaluateInfo) {
        //获取用户id
        String userId = AuthUtils.getCurrentUserId();
        evaluateInfo.setUserCode(userId);
        int count = clientOrderDao.addGoodsEvaluate(evaluateInfo);
        if (evaluateInfo.getListAssess().size() != count){
            return AppResponse.bizError("评价失败！");
        }
        //将订单状态改成已评价
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderCode(evaluateInfo.getOrderCode());
        orderInfo.setOrderState("3");
        orderInfo.setUserId(userId);
        int count1 = clientOrderDao.updateOrderState(orderInfo);
        if(count1 == 0){
            return AppResponse.bizError("订单状态修改错误！");
        }
        //得到商品编号列表
        List<String> listGoods = new ArrayList<>();
        for(int i = 0;i<evaluateInfo.getListAssess().size();i++){
            listGoods.add(evaluateInfo.getListAssess().get(i).getGoodsCode());
        }
        //计算商品星级
        System.out.println("===="+listGoods.size());
        List<String> listLevel = clientOrderDao.getAvgLevel(listGoods);
        System.out.println(listLevel.size()+"=======");
        List<GoodsLevelInfo> list = new ArrayList<>();
        for (int i = 0; i < evaluateInfo.getListAssess().size(); i++){
            GoodsLevelInfo goodsLevelInfo = new GoodsLevelInfo();
            goodsLevelInfo.setGoodsCode(listGoods.get(i));
            goodsLevelInfo.setGoodsStar(listLevel.get(i));
            list.add(goodsLevelInfo);
        }
        clientOrderDao.updateGoodsStar(list);
        return AppResponse.success("评价成功！");
    }
}
