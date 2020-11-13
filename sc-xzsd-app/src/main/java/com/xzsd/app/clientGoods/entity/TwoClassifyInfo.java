package com.xzsd.app.clientGoods.entity;

import java.util.List;

/**
 * 二级分类商品实体类
 * @author cairuifeng
 * @date 2020-04-24
 */
public class TwoClassifyInfo {
    /**
     * 分类代码
     */
    private String classifyCode;
    /**
     * 分类名称
     */
    private String classifyName;
    /**
     * 二级分类商品信息
     */
    private List<GoodsInfo> goodsList;

    public List<GoodsInfo> getGoodsList() {return goodsList; }

    public void setGoodsList(List<GoodsInfo> goodsList){ this.goodsList = goodsList; }

    public String getClassifyName() {return classifyName; }

    public void setClassifyName(String classifyName) {this.classifyName=classifyName; }

    public String getClassifyCode() {
        return classifyCode;
    }

    public void setClassifyCode(String classifyCode) {
        this.classifyCode = classifyCode;
    }
}
