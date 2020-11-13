package com.xzsd.app.managerOrder.controller;

import com.xzsd.app.clientOrder.controller.ClientOrderController;
import com.xzsd.app.clientOrder.entity.OrderInfo;
import com.xzsd.app.managerOrder.entity.ManagerOrderInfo;
import com.xzsd.app.managerOrder.service.ManagerOrderService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cairuifeng
 * @date 2020-05-04
 */
@RestController
@RequestMapping("/managerOrder")
public class ManagerOrderController {

    private static final Logger logger = LoggerFactory.getLogger(ManagerOrderController.class);

    @Resource
    private ManagerOrderService managerOrderService;

    /**
     * 订单列表
     * @param managerOrderInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-05-04
     */
    @RequestMapping(value = "listManagerOrders")
    public AppResponse listManagerOrders(ManagerOrderInfo managerOrderInfo) {
        try {
            return managerOrderService.listManagerOrders(managerOrderInfo);
        } catch (Exception e) {
            logger.error("查询订单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     * @param managerOrderInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-30
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(ManagerOrderInfo managerOrderInfo) {
        try {
            return managerOrderService.updateOrderState(managerOrderInfo);
        } catch (Exception e) {
            logger.error("修改订单状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * managerOrder 查询订单详情
     * @param orderCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-05-04
     */
    @RequestMapping(value = "listOrderDetails")
    public AppResponse listOrderDetails(String orderCode) {
        try {
            return managerOrderService.listOrderDetails(orderCode);
        } catch (Exception e) {
            logger.error("订单详情查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * managerOrder 查询司机
     * @param
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-05-04
     */
    @RequestMapping(value = "listDrivers")
    public AppResponse listDriver() {
        try {
            return managerOrderService.listDrivers();
        } catch (Exception e) {
            logger.error("司机查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * managerOrder 查询司机
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-05-04
     */
    @RequestMapping(value = "listDriverShop")
    public AppResponse listDriverShop() {
        try {
            return managerOrderService.listDriverShop();
        } catch (Exception e) {
            logger.error("门店查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
