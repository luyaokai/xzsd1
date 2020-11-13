package com.xzsd.app.clientHome.entity;

/**
 * app商品详情实体类
 * @author cairuifeng
 * @date 2020-04-23
 */
public class AppSlideshowInfo {
    /**
     * 轮播图图片路径
     */
    private String imagePath;
    /**
     * 商品编号
     */
    private String goodsCode;

    public String getImagePath() {return imagePath; }

    public void setImagePath(String imagePath) {this.imagePath = imagePath; }

    public String getGoodsCode() {return goodsCode; }

    public void setGoodsCode(String goodsCode) {this.goodsCode = goodsCode; }

}
