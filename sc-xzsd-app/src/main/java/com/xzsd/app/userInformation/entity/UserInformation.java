package com.xzsd.app.userInformation.entity;

import java.util.Date;

/**
 * 注册客户实体类
 * @author cairuifeng
 * @date 2020-04-21
 */
public class UserInformation {
    /**
     * 用户代码
     */
    private String userCode;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户登录名
     */
    private String userAcct;
    /**
     * 用户密码
     */
    private String userPwd;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 性别 0 男 1 女
     */
    private int sex;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 用户头像
     */
    private String imagePath;
    /**
     * 角色 0管理员，1店长，2司机
     */
    private String role;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDeleted;
    /**
     * 创建时间
     */
    private Date createTime1;
    /**
     * 创建者
     */
    private String createUser1;
    /**
     * 更新时间
     */
    private Date updateTime1;
    /**
     * 更新者
     */
    private String updateUser1;
    /**
     * 版本号
     */
    private String version;
    /**
     * 门店邀请码
     */
    private String inviteCode;
    /**
     * 店长门店账号
     */
    private String shopCode1;
    /**
     * 门店名称
     */
    private String shopName1;
    /**
     * 门店地址
     */
    private String address1;
    /**
     * 客户所在门店账号
     */
    private String shopCode2;
    /**
     * 门店名称
     */
    private String shopName2;
    /**
     * 门店地址
     */
    private String address2;

    public String getAddress2() {return address2; }

    public void setAddress2(String address2) {this.address2 = address2;}

    public String getShopName2() {return shopName2;};

    public void setShopName2(String shopName2) {this.shopName2 = shopName2;}

    public String getShopCode2() {
        return shopCode2;
    }

    public void setShopCode2(String shopCode2) {this.shopCode2 = shopCode2; }

    public String getAddress1() {return address1; }

    public void setAddress1(String address1) {this.address1 = address1;}

    public String getShopName1() {return shopName1;};

    public void setShopName1(String shopName1) {this.shopName1 = shopName1;}

    public String getShopCode1() {
        return shopCode1;
    }

    public void setShopCode1(String shopCode1) {this.shopCode1 = shopCode1; }

    public String getInviteCode() {return inviteCode; }

    public void setInviteCode(String inviteCode) {this.inviteCode = inviteCode; }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }


    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getRole() { return role; }

    public void setRole(String role) {this.role=role; }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime1() {
        return createTime1;
    }

    public void setCreateTime1(Date createTime1) {
        this.createTime1 = createTime1;
    }

    public String getCreateUser1() {
        return createUser1;
    }

    public void setCreateUser1(String createUser1) {
        this.createUser1 = createUser1;
    }

    public Date getUpdateTime1() {
        return updateTime1;
    }

    public void setUpdateTime1(Date updateTime1) {
        this.updateTime1 = updateTime1;
    }

    public String getUpdateUser1() {
        return updateUser1;
    }

    public void setUpdateUser1(String updateUser1) {
        this.updateUser1 = updateUser1;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
