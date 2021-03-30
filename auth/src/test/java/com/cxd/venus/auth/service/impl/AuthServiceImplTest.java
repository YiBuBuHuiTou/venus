package com.cxd.venus.auth.service.impl;

import com.cxd.venus.auth.bean.AccountBean;
import com.cxd.venus.auth.entity.Account;
import com.cxd.venus.auth.service.AccountService;
import com.cxd.venus.auth.service.AuthService;
import com.cxd.venus.constant.ENCRYPT_TYPE;
import com.cxd.venus.encrypt.CryptoUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class AuthServiceImplTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private AccountService accountService;

//    @BeforeAll
//    void addAccount() {
//        AccountBean accountBean = new AccountBean();
//        accountBean.setAccountName("Account_1");
//        accountBean.setPassword(CryptoUtils.hashAlgorithm(ENCRYPT_TYPE.SHA256, "Account_1"));
//        accountBean.setTenantId("TenantID");
//        boolean flag = accountService.addAccount(accountBean);
//        assertEquals(flag, true);
//    }

    @Test
    void check() {
        AccountBean accountBean = new AccountBean();
        accountBean.setAccountName("Account_1");
        accountBean.setPassword("Account_1");
        accountBean.setTenantId("TenantID");
        assertEquals(true, authService.check(accountBean.getAccountName(), accountBean.getPassword(), accountBean.getPassword()));
    }

    @Test
    void checkWithoutTenant() {
    }

    @Test
    void checkError() {
    }
}