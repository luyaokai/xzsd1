package com.xzsd.app.managerOrder.entity;

import java.util.Date;

/**
 * 门店信息
 * @author cairuifeng
 * @date 2020-05-04
 */
public class ShopInfo {
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 手机号码
     */
    private long phone;
    /**
     * 店长门店账号
     */
    private String shopCode;
    /**
     * 门店名称
     */
    private String shopName;
    /**
     * 门店地址
     */
    private String address;

    public String getAddress() {return address; }

    public void setAddress(String address) {this.address = address;}

    public String getShopName() {return shopName;};

    public void setShopName(String shopName) {this.shopName = shopName;}

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {this.shopCode = shopCode; }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
