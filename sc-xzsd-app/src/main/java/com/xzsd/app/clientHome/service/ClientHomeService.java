package com.xzsd.app.clientHome.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.clientHome.dao.ClientHomeDao;
import com.xzsd.app.clientHome.entity.AppHotGoodsInfo;
import com.xzsd.app.clientHome.entity.AppSlideshowInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cairfuieng
 * @date 2020-04-23
 */
@Service
public class ClientHomeService {

    @Resource
    private ClientHomeDao clientHomeDao;

    /**
     * clientHome 查询轮播图列表
     * @param appSlideshowInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-23
     */
    public AppResponse listSlideshow(AppSlideshowInfo appSlideshowInfo) {
        List<AppSlideshowInfo> appSlideshowInfoList = clientHomeDao.listSlideshow(appSlideshowInfo);
        return AppResponse.success("查询成功！",appSlideshowInfoList);
    }

    /**
     * clientHome 查询热门商品列表
     * @param appHotGoodsInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-23
     */
    public AppResponse listHotGoods(AppHotGoodsInfo appHotGoodsInfo) {
        List<AppHotGoodsInfo> appHotGoodsInfoList = clientHomeDao.listHotGoods(appHotGoodsInfo);
        return AppResponse.success("查询成功！",appHotGoodsInfoList);
    }
}
