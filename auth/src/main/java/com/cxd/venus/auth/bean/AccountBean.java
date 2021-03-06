package com.cxd.venus.auth.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 19:43
 * @Version 1.0
 **/

public class AccountBean implements Serializable {
    // 序列化类版本号
    private static final long serialVersionUID = 1L;

    //账号ID
    private String accountId;

    //用户ID
    private String accountName;

    //租户ID
    private String tenantId;

    // 密码
    private String password;

    // 秘钥
    private String securityKey;

    //描述
    private String description;

    //状态
    private int privilege;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }
}
