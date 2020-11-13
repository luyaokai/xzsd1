package com.xzsd.app.clientOrder.dao;

import com.xzsd.app.clientGoods.entity.AppGoodsInfo;
import com.xzsd.app.clientGoods.entity.GoodsEvaluateInfo;
import com.xzsd.app.clientGoods.entity.OneClassifyInfo;
import com.xzsd.app.clientOrder.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-27
 */
@Mapper
public interface ClientOrderDao {
    /**
     * 新增订单
     * @param clientOrderInfo 订单信息
     * @return
     */
    int addOrder(ClientOrderInfo clientOrderInfo);

    /**
     * 新增订单详情
     * @param orderList 订单信息
     * @return
     */
    int addOrderDetails(@Param("orderList") List<OrderDetailsInfo> orderList);

    /**
     * 删除购物车信息
     * @param listCode 选中的购物车编号集合
     * @return
     */
    int deleteShoppingCart(@Param("listCode") List<String> listCode);

    /**
     * 更新库存
     * @param orderList 库存信息
     * @return
     */
    int updateGoodsSum(@Param("orderList") List<OrderDetailsInfo> orderList);

    /**
     * 获取所有订单信息
     * @param orderInfo 订单信息
     * @return 用户所有订单信息
     */
    List<OrderInfo> listOrder(OrderInfo orderInfo);

    /**
     * 修改订单状态
     * @param orderInfo 订单信息
     * @return 修改结果
     */
    int updateOrderState(OrderInfo orderInfo);

    /**
     * 获取订单所有商品信息
     * @param orderCode 订单编号
     * @return 订单所有商品信息
     */
    List<GoodsInfo> listGoods(@Param("orderCode") String orderCode);

    /**
     * 库存回滚
     * @param list 库存信息
     * @return
     */
    int recoverGoodsSum(@Param("list") List<GoodsInfo> list);

    /**
     * 售量增加
     * @param list 库存信息
     * @return
     */
    int updateSellSum(@Param("list") List<GoodsInfo> list);

    /**
     * 获取订单所有详细信息
     * @param orderCode 订单编号
     * @return 订单所有详细信息
     */
    OrderInfo listOrderDetails(@Param("orderCode") String orderCode);

    /**
     * 查询商品评价信息
     * @param orderCode
     * @return 订单评价商品信息
     */
    List<GoodsInfo> listGoodsForEvaluate(@Param("orderCode") String orderCode);

    /**
     * 新增评价
     * @param evaluateInfo 评价信息
     * @return
     */
    int addGoodsEvaluate(EvaluateInfo evaluateInfo);

    /**
     * 获取商品评价星级
     * @param goodsCode
     * @return
     */
    List<String> getAvgLevel(@Param("goodsCode") List<String> goodsCode);

    /**
     * 更新商品星级
     * @param levelList 商品信息
     * @return
     */
    int updateGoodsStar(@Param("levelList") List<GoodsLevelInfo> levelList);

}
