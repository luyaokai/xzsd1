package com.xzsd.app.clientGoods.controller;

import com.xzsd.app.clientGoods.entity.GoodsEvaluateInfo;
import com.xzsd.app.clientGoods.entity.OneClassifyInfo;
import com.xzsd.app.clientGoods.entity.TwoClassifyInfo;
import com.xzsd.app.clientGoods.service.ClientGoodsService;
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
@RequestMapping("/clientGoods")
public class ClientGoodsController {

    private static final Logger logger = LoggerFactory.getLogger(ClientGoodsController.class);

    @Resource
    private ClientGoodsService clientGoodsService;

    /**
     * clientGoods 查询商品详情
     * @param goodsCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-23
     */
    @RequestMapping(value = "getGoods")
    public AppResponse getGoods(String goodsCode) {
        try {
            return clientGoodsService.getGoods(goodsCode);
        } catch (Exception e) {
            logger.error("商品详情查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientGoods 商品列表(分页)
     * @param goodsEvaluateInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-24
     */
    @RequestMapping(value = "listGoodsEvaluates")
    public AppResponse listGoodsEvaluates(GoodsEvaluateInfo goodsEvaluateInfo) {
        try {
            return clientGoodsService.listGoodsEvaluates(goodsEvaluateInfo);
        } catch (Exception e) {
            logger.error("查询商品评价列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientGoods 热门商品列表
     *
     * @param oneGoodsClassifyInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-24
     */
    @RequestMapping(value = "listOneGoodsClassify")
    public AppResponse listOneGoodsClassify(OneClassifyInfo oneGoodsClassifyInfo) {
        try {
            return clientGoodsService.listOneGoodsClassify(oneGoodsClassifyInfo);
        } catch (Exception e) {
            logger.error("查询商品一级分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 一级分类下二级分类及商品列表
     * @param twoClassifyInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-25
     */
    @RequestMapping(value = "listGetClassGoods")
    public AppResponse listGetClassGoods(TwoClassifyInfo twoClassifyInfo) {
        try {
            return clientGoodsService.listGetClassGoods(twoClassifyInfo);
        } catch (Exception e) {
            logger.error("查二级分类及商品异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}

