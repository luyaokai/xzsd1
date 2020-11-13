package com.xzsd.app.clientGoods.entity;

/**
 * 二级分类下的商品实体类
 * @author cairuifeng
 * @date 2020-04-24
 */
public class GoodsInfo {
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
     * 商品图片路径
     */
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
