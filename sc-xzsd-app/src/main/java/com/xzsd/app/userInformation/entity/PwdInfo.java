package com.xzsd.app.userInformation.entity;

import java.util.Date;

/**
 * 密码实体类
 * @author cairuifeng
 */
public class PwdInfo {
    /**
     *版本号
     */
    private String version;
    /**
     * 现密码
     */
    private String userPwd;
    /**
     * 旧密码
     */
    private String oldPwd;
    /**
     * 新密码
     */
    private String newPwd;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户角色
     */
    private String role;

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role; }

    public String getUserId() {return userId; }

    public void setUserId(String userId) {this.userId = userId; }

    public String getVersion() {return version; }

    public void setVersion(String version) {this.version = version; }

    public String getUserPwd() {return userPwd; }

    public void setUserPwd(String userPwd) {this.userPwd =userPwd;}

    public String getOldPwd() {return oldPwd;  }

    public void setOldPwd(String oldPwd) {this.oldPwd = oldPwd; }

    public String getNewPwd() {return newPwd; }

    public void setNewPwd(String newPwd) {this.newPwd = newPwd; }
}
