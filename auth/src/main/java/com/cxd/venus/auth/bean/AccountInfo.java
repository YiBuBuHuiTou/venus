package com.cxd.venus.auth.bean;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/9 22:38
 * @Version 1.0
 **/
@Entity
@Table(name = "account_info")
public class AccountInfo implements Serializable {

    // 序列化类版本号
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "account_id", updatable = false)
    private String accountId;

    @Column(name = "account_name", unique = true, nullable = false)
    private String accountName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "security_key")
    private String securityKey;


}
