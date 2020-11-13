package com.xzsd.app.clientGoods.entity;

/**
 * app商品实体类
 * @author cairuifeng
 * @date 2020-04-23
 */
public class AppGoodsInfo {
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 售价
     */
    private String sellPrice;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 出版社
     */
    private String goodsPress;
    /**
     * 作者
     */
    private String goodsAuthor;
    /**
     * 商品介绍
     */
    private String goodsIntroduce;
    /**
     * 书号
     */
    private String goodsIsbn;
    /**
     * 商品图片路径
     */
    private String imagePath;
    /**
     * 商品评价等级
     */
    private String starLevel;

    public String getStarLevel() {return starLevel; }

    public void setStarLevel(String starLevel) {this.starLevel = starLevel; }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getGoodsIsbn() {
        return goodsIsbn;
    }

    public void setGoodsIsbn(String goodsIsbn) {
        this.goodsIsbn = goodsIsbn;
    }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }

    public String getGoodsAuthor() {
        return goodsAuthor;
    }

    public void setGoodsAuthor(String goodsAuthor) {
        this.goodsAuthor = goodsAuthor;
    }

    public String getGoodsPress() {
        return goodsPress;
    }

    public void setGoodsPress(String goodsPress) {
        this.goodsPress = goodsPress;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
