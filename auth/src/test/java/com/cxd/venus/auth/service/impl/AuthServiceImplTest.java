package com.cxd.venus.auth.service.impl;

import com.cxd.venus.auth.bean.AuthBean;
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

    @BeforeAll
    void addAccount() {
        Account account = new Account();
        account.setAccountName("Account_1");
        account.setPassword(CryptoUtils.hashAlgorithm(ENCRYPT_TYPE.SHA256, "Account_1"));
        account.setTenantId("TenantID");
        boolean flag = accountService.addAccount(account);
        assertEquals(flag, true);
    }

    @Test
    void check() {
        AuthBean authBean = new AuthBean();
        authBean.setAccountName("Account_1");
        authBean.setPassword("Account_1");
        authBean.setTenantId("TenantID");
        assertEquals(authService.check(authBean), true);
    }

    @Test
    void checkWithoutTenant() {
    }

    @Test
    void checkError() {
    }
}