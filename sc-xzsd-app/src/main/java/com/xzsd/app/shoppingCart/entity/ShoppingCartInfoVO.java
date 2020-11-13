package com.xzsd.app.shoppingCart.entity;

/**
 * @author cairuifeng
 * @date 2020-04-26
 */
public class ShoppingCartInfoVO {
    /**
     * 购物车编号
     */
    private String cartCode;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品数量
     */
    private int goodsCount;
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品图片路径
     */
    private String imagePath;
    /**
     *售价
     */
    private String sellPrice;

    public String getImagePath() { return imagePath;}

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getGoodsName() {return goodsName;}

    public void setGoodsName(String goodsName) {this.goodsName = goodsName;}

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getCartCode() {return cartCode;}

    public void setCartCode(String cartCode) {this.cartCode = cartCode; }

    public String getUserCode() {return userCode;}

    public void setUserCode(String userCode) {this.userCode = userCode; }

    public String getGoodsCode() {return goodsCode;}

    public void setGoodsCode(String goodsCode) {this.goodsCode = goodsCode; }

    public int getGoodsCount() {return goodsCount;}

    public void setGoodsCount(int goodsCount) {this.goodsCount = goodsCount; }
}
