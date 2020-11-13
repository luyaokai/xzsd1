package com.xzsd.app.clientOrder.entity;

/**
 * 商品详情实体类
 * @author cairuifeng
 * @date 2020-04--29
 */
public class OrderDetailsInfo {
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 售价
     */
    private String sellPrice;
    /**
     * 客户选择商品数量
     */
    private String goodsCount;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 商品详情总金额
     */
    private String orderDetailsCost;
    /**
     * 用户编号
     */
    private String userId;

    public String getUserId() {return userId;}

    public void setUserId(String userId) {this.userId = userId;}

    public String getOrderDetailsCost() {return orderDetailsCost;}

    public void setOrderDetailsCost(String orderDetailsCost) {this.orderDetailsCost = orderDetailsCost;}

    public String getOrderCode() {return orderCode;}

    public void setOrderCode(String orderCode) {this.orderCode = orderCode; }

    public String getGoodsCode() {return goodsCode;}

    public void setGoodsCode(String goodsCode) {this.goodsCode = goodsCode; }

    public String getSellPrice() {return sellPrice;}

    public void setSellPrice(String sellPrice) {this.sellPrice = sellPrice;}

    public String getGoodsCount() {return goodsCount;}

    public void setGoodsCount(String goodsCount) {this.goodsCount= goodsCount;}
}
