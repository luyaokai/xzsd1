package com.xzsd.app.managerOrder.entity;

/**
 * 司机实体类
 * @author cairufieng
 * @date 2020-05-04
 */
public class DriverInfo {
    /**
     * 用户名字
     */
    private String userName;
    /**
     * 用户电话
     */
    private long phone;

    public long getPhone() {return phone;}

    public void setPhone(long phone){this.phone = phone;}

    public String getUserName() {return userName;}

    public void setUserName(String userName) {this.userName = userName;}
}
