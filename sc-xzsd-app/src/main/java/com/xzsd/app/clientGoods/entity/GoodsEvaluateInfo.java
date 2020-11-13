package com.xzsd.app.clientGoods.entity;

/**
 * 商品评价实体类
 * @author cairuifeng
 * @date 2020-4-24
 */
public class GoodsEvaluateInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 评价等级
     */
    private String evaluateLevel;
    /**
     * 用户账号
     */
    private String userAcct;
    /**
     * 评价内容
     */
    private String evaluateContent;
    /**
     * 评价时间
     */
    private String evaluateTime;

    public String getEvaluateTime() {return evaluateTime;}

    public void setEvaluateTime(String evaluateTime) {this.evaluateTime = evaluateTime;}

    public String getEvaluateContent() {return evaluateContent;}

    public void setEvaluateContent(String evaluateContent) {this.evaluateContent = evaluateContent;}

    public String getUserAcct() {return userAcct; }

    public void setUserAcct(String userAcct) {this.userAcct = userAcct; }

    public String getEvaluateLevel() {return evaluateLevel;}

    public void setEvaluateLevel(String evaluateLevel) {this.evaluateLevel = evaluateLevel;}

    public String getGoodsCode() {return goodsCode; }

    public void setGoodsCode(String goodsCode) {this.goodsCode =goodsCode; }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
