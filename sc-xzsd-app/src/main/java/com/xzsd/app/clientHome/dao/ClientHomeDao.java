package com.xzsd.app.clientHome.dao;

import com.xzsd.app.clientHome.entity.AppHotGoodsInfo;
import com.xzsd.app.clientHome.entity.AppSlideshowInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-23
 */
@Mapper
public interface ClientHomeDao {

    /**
     * 获取所有轮播图信息
     * @param appSlideshowInfo 轮播图信息
     * @return 所有轮播图信息
     */
    List<AppSlideshowInfo> listSlideshow(AppSlideshowInfo appSlideshowInfo);

    /**
     * 获取所有热门商品信息
     * @param appHotGoodsInfo 热门商品信息
     * @return 所有轮播图信息
     */
    List<AppHotGoodsInfo> listHotGoods(AppHotGoodsInfo appHotGoodsInfo);

}
