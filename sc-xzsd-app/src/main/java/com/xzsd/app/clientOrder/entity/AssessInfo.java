package com.xzsd.app.clientOrder.entity;

/**
 * 评价列表内容
 * @author cairuifeng
 * @date 2020-05-03
 */
public class AssessInfo {
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 评价等级
     */
    private String evaluateLevel;
    /**
     * 评价内容
     */
    private String evaluateContent;

    public String getEvaluateContent() {return evaluateContent;}

    public void setEvaluateContent(String evaluateContent) {this.evaluateContent = evaluateContent;}

    public String getEvaluateLevel() {return evaluateLevel;}

    public void setEvaluateLevel(String evaluateLevel) {this.evaluateLevel = evaluateLevel;}

    public String getGoodsCode() {return goodsCode; }

    public void setGoodsCode(String goodsCode) {this.goodsCode =goodsCode; }
}
