package com.cxd.venus.auth.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/11 20:48
 * @Version 1.0
 **/
@Entity
@Table(name = "password")
public class Password implements Serializable {
    // 序列化类版本号
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "account_id", updatable = false)
    private String accountId;

    @Column(name = "password", updatable = false)
    private String password;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    private Date createDate;


    /**********************************************************************************************************************************************************/
    /*******************************************   Getter And Setter   ****************************************************************************************/
    /**********************************************************************************************************************************************************/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
