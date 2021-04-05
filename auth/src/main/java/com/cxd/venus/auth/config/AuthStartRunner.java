package com.cxd.venus.auth.config;

import com.cxd.venus.auth.bean.AccountBean;
import com.cxd.venus.auth.bean.TenantBean;
import com.cxd.venus.auth.entity.Tenant;
import com.cxd.venus.auth.service.AccountService;
import com.cxd.venus.auth.service.TenantService;
import com.cxd.venus.constant.ENCRYPT_TYPE;
import com.cxd.venus.encrypt.CryptoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

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
        System.out.println("服务启动执行，资源初始化......");
        System.out.println("校验初始化数据......");
        if(!tenantService.checkTenantExists("venus")) {
            System.out.println("顶层租户不存在");
            TenantBean tenantBean = new TenantBean();
            tenantBean.setTenantName("venus");
            tenantBean.setStatus(0xFFFF);
            tenantBean.setOwner("venus");
            tenantBean.setDescription("顶层租户");
            Assert.isTrue(tenantService.addTenant(tenantBean),"租户追加失败");
        }
        if(accountService.getAccountByAccountName("venus") == null) {
            System.out.println("顶层管理员用户账号不存在");
            AccountBean accountBean = new AccountBean();
            accountBean.setAccountName("venus");
            accountBean.setPassword(CryptoUtils.hashAlgorithm(ENCRYPT_TYPE.SHA256, "venus"));
            accountBean.setTenantId("venus");
            accountBean.setDescription("顶层管理员");
            accountBean.setPrivilege(0xFFFF);
            Assert.isTrue(accountService.addAccount(accountBean), "管理员追加失败");
        }
        System.out.println(">>>>>>>>>>>>>>>服务启动成功。<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
