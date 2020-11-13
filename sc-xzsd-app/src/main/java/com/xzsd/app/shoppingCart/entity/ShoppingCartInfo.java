package com.xzsd.app.shoppingCart.entity;

/**
 * 购物车实体类
 * @author cairuifeng
 * @date 2020-04-20
 */
public class ShoppingCartInfo {
    /**
     * 购物车编号
     */
    private String cartCode;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品数量
     */
    private int goodsCount;
    /**
     *售价
     */
    private String sellPrice;

    public String getCartCode() {return cartCode;}

    public void setCartCode(String cartCode) {this.cartCode = cartCode; }

    public String getUserCode() {return userCode;}

    public void setUserCode(String userCode) {this.userCode = userCode; }

    public String getGoodsCode() {return goodsCode;}

    public void setGoodsCode(String goodsCode) {this.goodsCode = goodsCode; }

    public int getGoodsCount() {return goodsCount;}

    public void setGoodsCount(int goodsCount) {this.goodsCount = goodsCount; }
}

