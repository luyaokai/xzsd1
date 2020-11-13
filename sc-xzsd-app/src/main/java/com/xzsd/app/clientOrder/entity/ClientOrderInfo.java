package com.xzsd.app.clientOrder.entity;

/**
 * 客户订单实体类
 * @author cairuifeng
 */
public class ClientOrderInfo {
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
     * 购物车编号
     */
    private String cartCode;
    /**
     *门店编号
     */
    private String shopCode2;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单总价
     */
    private String orderCost;
    /**
     * 订单状态
     */
    private int orderState;
    /**
     * 用户
     */
    private String userId;
    /**
     * 确认付款时间
     */
    private String payTime;
    /**
     * 商品详情总金额
     */
    private String orderDetailsCost;
    /**
     * 订单商品数量
     */
    private int orderGoodsCount;

    public int getOrderGoodsCount() {return orderGoodsCount;}

    public void setOrderGoodsCount(int orderGoodsCount){this.orderGoodsCount = orderGoodsCount;}

    public String getOrderDetailsCost() {return orderDetailsCost;}

    public void setOrderDetailsCost(String orderDetailsCost) {this.orderDetailsCost = orderDetailsCost;}

    public String getPayTime() {return payTime;}

    public void setPayTime(String payTime) {this.payTime = payTime;}

    public String getUserId() {return userId;}

    public void setUserId(String userId) {this.userId = userId;}

    public int getOrderState() {return orderState;}

    public void setOrderState(int orderState) {this.orderState = orderState;}

    public String getOrderCost() {return orderCost;}

    public void setOrderCost(String orderCost) {this.orderCost = orderCost; }

    public String getOrderCode() {return orderCode;}

    public void setOrderCode(String orderCode) {this.orderCode = orderCode; }

    public String getGoodsCode() {return goodsCode;}

    public void setGoodsCode(String goodsCode) {this.goodsCode = goodsCode; }

    public String getSellPrice() {return sellPrice;}

    public void setSellPrice(String sellPrice) {this.sellPrice = sellPrice;}

    public String getGoodsCount() {return goodsCount;}

    public void setGoodsCount(String goodsCount) {this.goodsCount= goodsCount;}

    public String getCartCode() {return cartCode;}

    public void setCartCode(String cartCode) {this.cartCode = cartCode;}

    public String getShopCode2() {return shopCode2;}

    public void setShopCode2(String shopCode2) {this.shopCode2 = shopCode2; }
}
