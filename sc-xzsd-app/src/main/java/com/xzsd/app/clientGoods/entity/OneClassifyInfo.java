package com.xzsd.app.clientGoods.entity;

/**
 * 商品一级分类实体类
 * @author cairuifeng
 * @date 2020-04-24
 */
public class OneClassifyInfo {
    /**
     * 分类代码
     */
    private String classifyCode;
    /**
     * 分类名称
     */
    private String classifyName;

    public String getClassifyName() {return classifyName; }

    public void setClassifyName(String classifyName) {this.classifyName=classifyName; }

    public String getClassifyCode() {
        return classifyCode;
    }

    public void setClassifyCode(String classifyCode) {
        this.classifyCode = classifyCode;
    }
}
