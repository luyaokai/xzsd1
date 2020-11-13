package com.xzsd.app.userInformation.controller;

import com.xzsd.app.userInformation.entity.PwdInfo;
import com.xzsd.app.userInformation.entity.UserInformation;
import com.xzsd.app.userInformation.service.UserService;
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
 * @date 2020-04-21
 */
@RestController
@RequestMapping("/userInformation")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * userInformation 新增用户
     * @param userInformation
     * @return AppResponse
     * @author cairufieng
     * @Date 2020-04-21
     */
    @PostMapping("clientRegister")
    public AppResponse clientRegister(UserInformation userInformation) {
        try {
            AppResponse appResponse = userService.clientRegister(userInformation);
            return appResponse;
        } catch (Exception e) {
            logger.error("客户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * userInformation 查询用户详情
     *
     * @param
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-22
     */
    @RequestMapping(value = "getUser")
    public AppResponse getUser() {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return userService.getUser(userId);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * userInformation 修改密码
     * @param pwdInfo
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-04-25
     */
    @PostMapping("updatePwd")
    public AppResponse updatePwd(PwdInfo pwdInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return userService.updatePwd(pwdInfo,userId);
        } catch (Exception e) {
            logger.error("修改用户密码错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * userInformation 修改邀请码
     * @param userInformation
     * @return AppResponse
     * @author cairuifeng
     * @Date 2020-05-04
     */
    @PostMapping("updateInviteCode")
    public AppResponse updateInviteCode(UserInformation userInformation) {
        try {
            return userService.updateInviteCode(userInformation);
        } catch (Exception e) {
            logger.error("修改邀请码错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
