package com.xzsd.app.clientHome.controller;

import com.xzsd.app.clientHome.entity.AppHotGoodsInfo;
import com.xzsd.app.clientHome.entity.AppSlideshowInfo;
import com.xzsd.app.clientHome.service.ClientHomeService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cairuifeng
 * @date 2020-04-23
 */
@RestController
@RequestMapping("/clientHome")
public class ClientHomeController {

    private static final Logger logger = LoggerFactory.getLogger(ClientHomeController.class);

    @Resource
    private ClientHomeService clientHomeService;

    /**
     * clientHome 轮播图列表
     *
     * @param appSlideshowInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-23
     */
    @RequestMapping(value = "listSlideshow")
    public AppResponse listSlideshow(AppSlideshowInfo appSlideshowInfo) {
        try {
            return clientHomeService.listSlideshow(appSlideshowInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientHome 热门商品列表
     *
     * @param appHotGoodsInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-23
     */
    @RequestMapping(value = "listHotGoods")
    public AppResponse listHotGoods(AppHotGoodsInfo appHotGoodsInfo) {
        try {
            return clientHomeService.listHotGoods(appHotGoodsInfo);
        } catch (Exception e) {
            logger.error("查询热门商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
