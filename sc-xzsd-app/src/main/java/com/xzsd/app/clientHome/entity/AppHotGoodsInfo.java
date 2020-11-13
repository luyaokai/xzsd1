package com.xzsd.app.clientHome.entity;

/**
 * app热门商品实体类
 * @author cairfuieng
 * @date 2020-04-23
 */
public class AppHotGoodsInfo {
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品图片路径
     */
    private String imagePath;
    /**
     * 售价
     */
    private String sellPrice;

    public String getGoodsCode () {return goodsCode;}

    public void setGoodsCode(String goodsCode ) {this.goodsCode = goodsCode;}

    public String getGoodsName () {return goodsName;}

    public void setGoodsName(String goodsName ) {this.goodsName = goodsName;}

    public String getImagePath () {return imagePath;}

    public void setImagePath(String imagePath ) {this.imagePath = imagePath;}

    public String getSellPrice () {return sellPrice;}

    public void setSellPrice(String sellPrice) {this.sellPrice = sellPrice;}
}
