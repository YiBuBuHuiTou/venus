package com.cxd.venus.auth.bean;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 19:43
 * @Version 1.0
 **/
public class AuthBean implements Serializable {
    // 序列化类版本号
    private static final long serialVersionUID = 1L;

    //用户ID
    private String accountName;

    //租户ID
    private String tenantId;

    // 密码
    private String password;

    // 秘钥
    private String securityKey;

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
}
