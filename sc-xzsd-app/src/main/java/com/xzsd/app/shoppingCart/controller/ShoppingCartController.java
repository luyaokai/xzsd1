package com.xzsd.app.shoppingCart.controller;

import com.xzsd.app.shoppingCart.entity.ShoppingCartInfo;
import com.xzsd.app.shoppingCart.entity.ShoppingCartInfoVO;
import com.xzsd.app.shoppingCart.service.ShoppingCartService;
import com.xzsd.app.userInformation.controller.UserController;
import com.xzsd.app.userInformation.entity.UserInformation;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author cairuifeng
 * @date 2020-04-26
 */
@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    @Resource
    private ShoppingCartService shoppingCartService;

    /**
     * shippingCart 新增购物车
     * @param shoppingCartInfo
     * @return AppResponse
     * @author cairufieng
     * @Date 2020-04-26
     */
    @PostMapping("addShoppingCart")
    public AppResponse addShoppingCart(ShoppingCartInfo shoppingCartInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            AppResponse appResponse = shoppingCartService.addShoppingCart(shoppingCartInfo,userId);
            return appResponse;
        } catch (Exception e) {
            logger.error("购物车新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * shoppingCart 修改购物车
     * @param shoppingCartInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-26
     */
    @PostMapping("updateShoppingCart")
    public AppResponse updateShoppingCart(ShoppingCartInfo shoppingCartInfo) {
        try {
            return shoppingCartService.updateShoppingCart(shoppingCartInfo);
        } catch (Exception e) {
            logger.error("修改购物车信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * shoppingCart 购物车列表(分页)
     * @param shoppingCartInfoVO
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-26
     */
    @RequestMapping(value = "listShoppingCarts")
    public AppResponse listShoppingCarts(ShoppingCartInfoVO shoppingCartInfoVO) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return shoppingCartService.listShoppingCarts(shoppingCartInfoVO,userId);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * shoppingCart 删除购物车
     * @param cartCode
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-26
     */
    @PostMapping("deleteShoppingCart")
    public AppResponse deleteShoppingCart(String cartCode) {
        try {
            return shoppingCartService.deleteShoppingCart(cartCode);
        } catch (Exception e) {
            logger.error("购物车删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
