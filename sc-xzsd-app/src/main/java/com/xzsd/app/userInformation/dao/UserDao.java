package com.xzsd.app.userInformation.dao;

import com.xzsd.app.userInformation.entity.AddressInfo;
import com.xzsd.app.userInformation.entity.PwdInfo;
import com.xzsd.app.userInformation.entity.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author cairuifeng
 * @date 2020-04-22
 */
@Mapper
public interface UserDao {
    /**
     * 统计客户账号数量
     * @param userInformation 用户信息
     * @return
     */
    int countUserAcct(UserInformation userInformation);

    /**
     * 判断邀请码是否存在
     * @param userInformation 用户信息
     * @return
     */
    int countInviteCode(UserInformation userInformation);

    /**
     * 判断用户是否绑定邀请码
     * @param userId 登陆人信息
     * @return
     */
    int countInviteCode1(@Param("userId") String userId);

    /**
     * 获取登陆角色
     * @param userId 登陆人
     * @return
     */
    String getRole(@Param("userId") String userId);

    /**
     * 新增用户
     * @param userInformation 用户信息
     * @return
     */
    int clientRegister(UserInformation userInformation);

    /**
     * 查询用户信息
     * @param userId
     * @return 用户信息
     */
    UserInformation getUser(@Param("userId") String userId);

    /**
     * 查询店长或顾客所在的门店地址
     * @param userId
     * @param role
     * @return 省市区信息
     */
    AddressInfo getAddress(@Param("userId") String userId, @Param("role") String role);

    /**
     * 查询用户密码
     * @param userId
     * @return 用户密码
     */
    String getUserPwd(@Param("userId") String userId);

    /**
     * 修改用户密码
     * @param pwdInfo 密码信息
     * @return 修改结果
     */
    int updatePwd(PwdInfo pwdInfo);

    /**
     * 修改用户邀请码
     * @param userInformation 用户信息
     * @return 修改结果
     */
    int updateInviteCode(UserInformation userInformation);
}
