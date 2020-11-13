package com.xzsd.app.shoppingCart.dao;

import com.xzsd.app.clientGoods.entity.GoodsEvaluateInfo;
import com.xzsd.app.shoppingCart.entity.ShoppingCartInfo;
import com.xzsd.app.shoppingCart.entity.ShoppingCartInfoVO;
import com.xzsd.app.userInformation.entity.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-26
 */
@Mapper
public interface ShoppingCartDao {
    /**
     * 新增购物车
     * @param shoppingCartInfo 购物车信息
     * @return
     */
    int addShoppingCart(ShoppingCartInfo shoppingCartInfo);

    /**
     * 统计商品数量
     * @param shoppingCartInfo 购物车信息
     * @return
     */
    int countGoods(ShoppingCartInfo shoppingCartInfo);

    /**
     * 统计商品购买数量
     * @param shoppingCartInfo 购物车信息
     * @return
     */
    int getGoodsCount(ShoppingCartInfo shoppingCartInfo);

    /**
     * 修改购物车信息
     * @param shoppingCartInfo 购物车信息
     * @return 修改结果
     */
    int updateShoppingCart(ShoppingCartInfo shoppingCartInfo);

    /**
     * 统计商品库存
     * @param shoppingCartInfo 商品库存信息
     * @return
     */
    int getGoodsSum(ShoppingCartInfo shoppingCartInfo);

    /**
     * 获取购物车信息
     * @param shoppingCartInfoVO 购物车信息
     * @return 用户购物车所有信息
     */
    List<ShoppingCartInfoVO> listShoppingCartsByPage(ShoppingCartInfoVO shoppingCartInfoVO);

    /**
     * 删除购物车信息
     * @param listCode 选中的购物车编号集合
     * @return
     */
    int deleteShoppingCart(@Param("listCode") List<String> listCode);
}
