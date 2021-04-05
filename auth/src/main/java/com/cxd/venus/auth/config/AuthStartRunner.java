package com.cxd.venus.auth.config;

import com.cxd.venus.auth.service.AccountService;
import com.cxd.venus.auth.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/4/5 20:13
 * @Version 1.0
 **/
@Component
@Order(value = 1)  // 如果有多个，则这个为第一个执行
public class AuthStartRunner implements CommandLineRunner {

    private AccountService accountService;

    private TenantService tenantService;

    @Autowired
    public AuthStartRunner(AccountService accountService, TenantService tenantService) {
        this.accountService = accountService;
        this.tenantService = tenantService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，资源初始化<<<<<<<<<<<<<<<<");

        System.out.println(">>>>>>>>>>>>>>>服务启动成功。<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
