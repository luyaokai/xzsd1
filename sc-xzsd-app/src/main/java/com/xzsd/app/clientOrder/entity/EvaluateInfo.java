package com.xzsd.app.clientOrder.entity;

import java.util.List;

/**
 * 订单评价实体类
 * @author cairuifeng
 * @date 2020-05-02
 */
public class EvaluateInfo {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 评价列表集合
     */
    private List<AssessInfo> listAssess;

    public List<AssessInfo> getListAssess() {return listAssess; }

    public void setListAssess(List<AssessInfo> listAssess) {this.listAssess = listAssess;}

    public String getOrderCode() {return orderCode;}

    public void setOrderCode(String orderCode) {this.orderCode = orderCode;}

    public String getUserCode() {return userCode; }

    public void setUserCode(String userCode) {this.userCode = userCode; }


}
