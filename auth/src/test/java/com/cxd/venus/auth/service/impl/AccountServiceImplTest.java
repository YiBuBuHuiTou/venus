package com.cxd.venus.auth.service.impl;

import com.cxd.venus.auth.bean.AccountBean;
import com.cxd.venus.auth.service.AccountService;
import com.cxd.venus.constant.ENCRYPT_TYPE;
import com.cxd.venus.encrypt.CryptoUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    void addAccount() {
        AccountBean accountbean = new AccountBean();
        accountbean.setAccountName("Account_1"+new Random().nextFloat());
        accountbean.setTenantId("DEFAULT");
        accountbean.setPassword(CryptoUtils.hashAlgorithm(ENCRYPT_TYPE.SHA256, "Account_1"));
//        accountbean.setTenantId("TenantID");
        boolean flag = accountService.addAccount(accountbean);
        assertEquals(flag, true);
    }
}