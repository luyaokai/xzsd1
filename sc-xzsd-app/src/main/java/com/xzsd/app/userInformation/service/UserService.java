package com.xzsd.app.userInformation.service;

import com.xzsd.app.userInformation.dao.UserDao;
import com.xzsd.app.userInformation.entity.AddressInfo;
import com.xzsd.app.userInformation.entity.PwdInfo;
import com.xzsd.app.userInformation.entity.UserInformation;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.AuthUtils;
import com.xzsd.app.util.PasswordUtils;
import com.xzsd.app.util.StringUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author cairuifeng
 * @date 2020-04-21
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * userInformation 新增客户
     * @param userInformation
     * @return
     * @Author cairuifeng
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse clientRegister(UserInformation userInformation) {
        // 校验账号是否存在
        int countUserAcct = userDao.countUserAcct(userInformation);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        //如果邀请码不为空
        if(userInformation.getInviteCode() != null && userInformation.getInviteCode().length() != 0){
            //检验邀请码是否存在
            int countInviteCode = userDao.countInviteCode(userInformation);
            if(0 == countInviteCode) {
                return AppResponse.bizError("邀请码不存在，请重新输入！");
            }
        }
        userInformation.setInviteCode("YQM234204");
        userInformation.setUserCode(StringUtil.getCommonCode(2));
        userInformation.setIsDeleted(0);
        userInformation.setUserPwd(PasswordUtils.generatePassword(userInformation.getUserPwd()));
        // 新增用户
        int count = userDao.clientRegister(userInformation);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * userInformation 查询用户详情
     * @param userId
     * @return
     * @Author cairuifeng
     * @Date 2020-04-22
     */
    public AppResponse getUser(String userId) {
        UserInformation userInformation = userDao.getUser(userId);
        if(!"2".equals(userInformation.getRole())) {
            System.out.println("++"+userInformation.getRole());
            System.out.println("===="+userId);
            AddressInfo addressInfo = userDao.getAddress(userId, userInformation.getRole());
            System.out.println("===="+addressInfo.getProvinceName());
            String provinceName = addressInfo.getProvinceName();
            String cityName = addressInfo.getCityName();
            String areaName = addressInfo.getAreaName();
            if ("1".equals(userInformation.getRole())) {
                userInformation.setAddress1(provinceName + cityName + areaName + userInformation.getAddress1());
            }
            if ("3".equals(userInformation.getRole())) {
                userInformation.setAddress2(provinceName + cityName + areaName + userInformation.getAddress2());
            }
        }
        return AppResponse.success("查询成功！",userInformation);
    }

    /**
     * userInformation 修改密码
     * @param pwdInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-22
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updatePwd(PwdInfo pwdInfo, String userId) {
        AppResponse appResponse = AppResponse.success("修改成功");
        //获取旧密码
        String userPwd = userDao.getUserPwd(userId);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean flag = bCryptPasswordEncoder.matches(pwdInfo.getOldPwd(),userPwd);
        if(!flag) {
            return AppResponse.bizError("新旧密码不相等");
        }
        //获取当前登陆人角色
        String role = userDao.getRole(userId);
        pwdInfo.setRole(role);
        pwdInfo.setUserId(userId);
        pwdInfo.setNewPwd(PasswordUtils.generatePassword(pwdInfo.getNewPwd()));
        // 修改用户密码
        int count = userDao.updatePwd(pwdInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * userInformation 修改邀请码
     * @param userInformation
     * @return
     * @Author cairuifeng
     * @Date 2020-05-04
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateInviteCode(UserInformation userInformation) {
        AppResponse appResponse = AppResponse.success("修改成功");
        //获取用户id
        String userId = AuthUtils.getCurrentUserId();
        userInformation.setUserCode(userId);
        // 修改用户信息
        int count = userDao.updateInviteCode(userInformation);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }
}
