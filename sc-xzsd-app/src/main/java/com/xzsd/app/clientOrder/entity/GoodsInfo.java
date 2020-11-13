package com.xzsd.app.clientOrder.entity;

/**
 * 订单内商品实体类
 * @author cairuifeng
 * @date 2020-04-29
 */
public class GoodsInfo {
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     *售价
     */
    private String sellPrice;
    /**
     * 商品介绍
     */
    private String goodsIntroduce;
    /**
     * 商品图片路径
     */
    private String imagePath;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品数量
     */
    private String goodsCount;

    public String getGoodsCount() {return goodsCount;}

    public void setGoodsCount(String goodsCount) {this.goodsCount = goodsCount;}

    public String getImagePath() { return imagePath;}

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
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
