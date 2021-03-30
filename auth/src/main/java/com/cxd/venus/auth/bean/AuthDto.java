package com.cxd.venus.auth.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/30 23:35
 * @Version 1.0
 **/
@ApiModel
public class AuthDto {
    // 序列化类版本号
    private static final long serialVersionUID = 1L;
    //账号ID
    @ApiModelProperty
    private String accountId;

    //用户ID
    @ApiModelProperty
    private String accountName;

    //租户ID
    @ApiModelProperty
    private String tenantId;

    // 密码
    @ApiModelProperty
    private String password;

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
}
