package com.xzsd.app.shoppingCart.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.shoppingCart.dao.ShoppingCartDao;
import com.xzsd.app.shoppingCart.entity.ShoppingCartInfo;
import com.xzsd.app.shoppingCart.entity.ShoppingCartInfoVO;
import com.xzsd.app.userInformation.entity.UserInformation;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.PasswordUtils;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-26
 */
@Service
public class ShoppingCartService {

    @Resource
    private ShoppingCartDao shoppingCartDao;

    /**
     * shoppingCart 新增购物车
     * @param shoppingCartInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addShoppingCart(ShoppingCartInfo shoppingCartInfo,String userId) {
        shoppingCartInfo.setUserCode(userId);
        //得到商品库存
        int getGoodsSum = shoppingCartDao.getGoodsSum(shoppingCartInfo);

        //判断购物车是否有此商品
        int countGoods = shoppingCartDao.countGoods(shoppingCartInfo);
        if(1 == countGoods) {
            //获取购物车商品购买数量
            int getGoodsCount = shoppingCartDao.getGoodsCount(shoppingCartInfo);
            // 校验购物车数量是否超过商品库存
            if(getGoodsSum < getGoodsCount+shoppingCartInfo.getGoodsCount()) {
                return AppResponse.bizError("商品库存不足");
            }
            // 修改购物车信息
            shoppingCartInfo.setGoodsCount(getGoodsCount+shoppingCartInfo.getGoodsCount());
            int count = shoppingCartDao.updateShoppingCart(shoppingCartInfo);
            if (0 == count) {
                return AppResponse.versionError("数据有变化，请刷新！");
            }
            return AppResponse.success("商品数量增加成功！");
        }else {
            if(getGoodsSum < shoppingCartInfo.getGoodsCount()) {
                return AppResponse.bizError("商品库存不足");
            }
            shoppingCartInfo.setCartCode(StringUtil.getCommonCode(2));
            // 新增购物车
            int count = shoppingCartDao.addShoppingCart(shoppingCartInfo);
            if(0 == count) {
                return AppResponse.bizError("新增失败，请重试！");
            }
            return AppResponse.success("新增成功！");
        }
    }

    /**
     * shoppingCart 修改购物车
     * @param shoppingCartInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateShoppingCart(ShoppingCartInfo shoppingCartInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 修改购物车信息
        int count = shoppingCartDao.updateShoppingCart(shoppingCartInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     *shoppingCart 查询购物车列表（分页）
     * @param shoppingCartInfoVO
     * @return
     * @Author cairuifeng
     * @Date 2020-04-26
     */
    public AppResponse listShoppingCarts(ShoppingCartInfoVO shoppingCartInfoVO,String userId) {
        shoppingCartInfoVO.setUserCode(userId);
        PageHelper.startPage(shoppingCartInfoVO.getPageNum(), shoppingCartInfoVO.getPageSize());
        List<ShoppingCartInfoVO> shoppingCartInfoVOList = shoppingCartDao.listShoppingCartsByPage(shoppingCartInfoVO);
        // 包装Page对象
        PageInfo<ShoppingCartInfoVO> pageData = new PageInfo<ShoppingCartInfoVO>(shoppingCartInfoVOList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * shoppingCart 删除购物车
     * @param userCode
     * @return
     * @Author cairuifeng
     * @Date 2020-04-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteShoppingCart(String userCode) {
        List<String> listCode = Arrays.asList(userCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = shoppingCartDao.deleteShoppingCart(listCode);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
