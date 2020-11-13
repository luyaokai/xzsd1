package com.xzsd.app.clientOrder.controller;

import com.google.common.collect.Ordering;
import com.xzsd.app.clientOrder.entity.ClientOrderInfo;
import com.xzsd.app.clientOrder.entity.EvaluateInfo;
import com.xzsd.app.clientOrder.entity.OrderInfo;
import com.xzsd.app.clientOrder.service.ClientOrderService;
import com.xzsd.app.util.AppResponse;
import jdk.nashorn.internal.ir.CallNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cairuifeng
 * @date 2020-04-28
 */
@RestController
@RequestMapping("/clientOrder")
public class ClientOrderController {

    private static final Logger logger = LoggerFactory.getLogger(ClientOrderController.class);

    @Resource
    private ClientOrderService clientOrderService;

    /**
     * clientOrder 新增订单
     * @param clientOrderInfo
     * @return AppResponse
     * @author cairufieng
     * @Date 2020-04-28
     */
    @PostMapping("addOrder")
    public AppResponse addOrder(ClientOrderInfo clientOrderInfo) {
        try {
            AppResponse appResponse = clientOrderService.addOrder(clientOrderInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("订单新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 订单列表
     * @param orderInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-29
     */
    @RequestMapping(value = "listOrder")
    public AppResponse listOrder(OrderInfo orderInfo) {
        try {
            return clientOrderService.listOrder(orderInfo);
        } catch (Exception e) {
            logger.error("查询订单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-30
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(OrderInfo orderInfo) {
        try {
            return clientOrderService.updateOrderState(orderInfo);
        } catch (Exception e) {
            logger.error("修改订单状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientOrder 查询订单详情
     * @param orderCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-30
     */
    @RequestMapping(value = "listOrderDetails")
    public AppResponse listOrderDetails(String orderCode) {
        try {
            return clientOrderService.listOrderDetails(orderCode);
        } catch (Exception e) {
            logger.error("订单详情查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientOrder 查询商品详情
     * @param orderCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-30
     */
    @RequestMapping(value = "listGoodsForEvaluate")
    public AppResponse getGoods(String orderCode) {
        try {
            return clientOrderService.listGoodsForEvaluate(orderCode);
        } catch (Exception e) {
            logger.error("商品详情查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientOrder 新增评价
     * @param evaluateInfo
     * @return AppResponse
     * @author cairufieng
     * @Date 2020-05-03
     */
    @PostMapping(value = "addGoodsEvaluate",headers = {"content-type=application/json"})
    public AppResponse addGoodsEvaluate(@RequestBody EvaluateInfo evaluateInfo) {
        try {
            AppResponse appResponse = clientOrderService.addGoodsEvaluate(evaluateInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("评价新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
