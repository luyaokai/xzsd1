package com.xzsd.app.managerOrder.dao;

import com.xzsd.app.clientOrder.entity.GoodsInfo;
import com.xzsd.app.clientOrder.entity.OrderInfo;
import com.xzsd.app.managerOrder.entity.DriverInfo;
import com.xzsd.app.managerOrder.entity.ManagerOrderInfo;
import com.xzsd.app.managerOrder.entity.ShopInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 */
@Mapper
public interface ManagerOrderDao {
    /**
     * 获取所有订单信息
     * @param managerOrderInfo 订单信息
     * @return 订单所有详细信息
     */
    List<ManagerOrderInfo> listManagerOrders(ManagerOrderInfo managerOrderInfo);

    /**
     * 修改订单状态
     * @param managerOrderInfo 订单信息
     * @return 修改结果
     */
    int updateOrderState(ManagerOrderInfo managerOrderInfo);

    /**
     * 获取订单所有详细信息
     * @param orderCode 订单编号
     * @return 订单所有详细信息
     */
    ManagerOrderInfo listOrderDetails(@Param("orderCode") String orderCode);

    /**
     * 查询司机信息
     * @param userId
     * @return 司机信息
     */
    List<DriverInfo> listDrivers(@Param("userId") String userId);

    /**
     * 查询门店信息
     * @param userId
     * @return 门店信息
     */
    List<ShopInfo> listDriverShop(@Param("userId") String userId);
}
