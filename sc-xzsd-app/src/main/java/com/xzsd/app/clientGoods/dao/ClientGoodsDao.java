package com.xzsd.app.clientGoods.dao;

import com.xzsd.app.clientGoods.entity.AppGoodsInfo;
import com.xzsd.app.clientGoods.entity.GoodsEvaluateInfo;
import com.xzsd.app.clientGoods.entity.OneClassifyInfo;
import com.xzsd.app.clientGoods.entity.TwoClassifyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-23
 */
@Mapper
public interface ClientGoodsDao {
    /**
     * 查询商品信息
     * @param goodsCode
     * @return 用户密码
     */
    AppGoodsInfo getGoods(@Param("goodsCode") String goodsCode);

    /**
     * 获取商品评价信息
     * @param goodsEvaluate 商品评价信息
     * @return 商品所有评价信息
     */
    List<GoodsEvaluateInfo> listGoodsEvaluatesByPage(GoodsEvaluateInfo goodsEvaluate);

    /**
     * 获取所有一级分类信息
     * @param oneClassifyInfo 热门商品信息
     * @return 所有一级分类信息
     */
    List<OneClassifyInfo> listOneGoodsClassify(OneClassifyInfo oneClassifyInfo);

    /**
     * 获取一级分类下所有商品分类和商品信息信息
     * @param twoClassifyInfo 二级分类信息
     * @return 一级分类下所有商品分类信息
     */
    List<TwoClassifyInfo> listGetClassGoods(TwoClassifyInfo twoClassifyInfo);

    /**
     * 增加观看量
     * @param goodsCode
     * @return
     */
    int updateSeeSum(@Param("goodsCode") String goodsCode);
}
