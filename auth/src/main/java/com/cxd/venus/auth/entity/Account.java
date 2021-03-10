package com.cxd.venus.auth.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/9 22:38
 * @Version 1.0
 **/
@Entity
@Table(name = "account")
public class Account implements Serializable {

    // 序列化类版本号
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "account_id", updatable = false)
    private String accountId;

    @Column(name = "tenant_id", nullable = false)
    private String tenantId;

    @Column(name = "account_name", unique = true, nullable = false)
    private String accountName;

    @Column(name = "password")
    private String password;

    @Column(name = "security_key")
    private String securityKey;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    private Date createDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private Date updateDate;

    /**********************************************************************************************************************************************************/
    /*******************************************   Getter And Setter   ****************************************************************************************/
    /**********************************************************************************************************************************************************/

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
