package com.xzsd.app.clientOrder.entity;

import java.util.List;

/**
 * 订单实体类
 * @author cairufieng
 * @date 2020-04-29
 */
public class OrderInfo {
    /**
     * 版本号
     */
    private String version;
    /**
     * 订单编码
     */
    private String orderCode;
    /**
     * 订单总价
     */
    private String orderCost;
    /**
     * 订单状态：0已下单，1已发货，2已完成未评价，3已完成已评价，4已取消，5已到货，6取消到货，7已取货，8取消已取货
     */
    private String orderState;
    /**
     * 订单商品种类数量
     */
    private int orderGoodsCount;
    /**
     * 订单商品信息
     */
    private List<GoodsInfo> goodsList;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 支付时间
     */
    private String payTime;

    public String getPayTime() {return payTime;}

    public void setPayTime(String payTime) {this.payTime = payTime;}

    public String getUserId() {return userId;}

    public void setUserId(String userId) {this.userId = userId;}

    public List<GoodsInfo> getGoodsList() {return goodsList; }

    public void setGoodsList(List<GoodsInfo> goodsList){ this.goodsList = goodsList; }

    public int getOrderGoodsCount() {return orderGoodsCount;}

    public void setOrderGoodsCount(int orderGoodsCount) {this.orderGoodsCount = orderGoodsCount;}

    public String getOrderState() {return orderState; }

    public void setOrderState(String orderState) {this.orderState = orderState; }

    public String getOrderCost() {return orderCost; }

    public void setOrderCost(String orderCost) {this.orderCost = orderCost; }

    public String getOrderCode() {return orderCode; }

    public void setOrderCode(String orderCode) {this.orderCode = orderCode; }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
