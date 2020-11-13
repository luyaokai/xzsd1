package com.xzsd.app.managerOrder.service;

import com.xzsd.app.clientOrder.entity.GoodsInfo;
import com.xzsd.app.clientOrder.entity.OrderInfo;
import com.xzsd.app.managerOrder.dao.ManagerOrderDao;
import com.xzsd.app.managerOrder.entity.DriverInfo;
import com.xzsd.app.managerOrder.entity.ManagerOrderInfo;
import com.xzsd.app.managerOrder.entity.ShopInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.AuthUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-05-04
 */
@Service
public class ManagerOrderService {

    @Resource
    private ManagerOrderDao managerOrderDao;

    /**
     * 查询订单列表
     * @param managerOrderInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-05-04
     */
    public AppResponse listManagerOrders(ManagerOrderInfo managerOrderInfo) {
        List<ManagerOrderInfo> managerOrderInfoList = managerOrderDao.listManagerOrders(managerOrderInfo);
        return AppResponse.success("查询成功！",managerOrderInfoList);
    }

    /**
     * clientOrder 修改订单状态
     * @param managerOrderInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-30
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(ManagerOrderInfo managerOrderInfo) {
        //获取用户id
        String userId = AuthUtils.getCurrentUserId();
        managerOrderInfo.setUserId(userId);
        // 修改订单状态
        int count = managerOrderDao.updateOrderState(managerOrderInfo);
        if (0 == count) {
            return AppResponse.versionError("数据有变化，请刷新！");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * 查询订单详情列表
     * @param orderCode
     * @return
     * @Author cairuifeng
     * @Date 2020-05-04
     */
    public AppResponse listOrderDetails(String orderCode) {
        ManagerOrderInfo managerOrderInfo= managerOrderDao.listOrderDetails(orderCode);
        return AppResponse.success("查询成功！",managerOrderInfo);
    }

    /**
     * managerOrder 查询司机
     * @param
     * @return
     * @Author cairuifeng
     * @Date 2020-05-04
     */
    public AppResponse listDrivers() {
        //获取用户id
        String userId = AuthUtils.getCurrentUserId();
        List<DriverInfo> driverInfoList = managerOrderDao.listDrivers(userId);
        return AppResponse.success("查询成功！", driverInfoList);
    }

    /**
     * managerOrder 查询司机
     * @return
     * @Author cairuifeng
     * @Date 2020-05-04
     */
    public AppResponse listDriverShop() {
        //获取用户id
        String userId = AuthUtils.getCurrentUserId();
        List<ShopInfo> shopInfoList = managerOrderDao.listDriverShop(userId);
        return AppResponse.success("查询成功！", shopInfoList);
    }
}
