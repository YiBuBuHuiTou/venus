package com.cxd.venus.auth.service.impl;

import com.cxd.venus.auth.bean.AccountBean;
import com.cxd.venus.auth.entity.Account;
import com.cxd.venus.auth.service.AccountService;
import com.cxd.venus.constant.ENCRYPT_TYPE;
import com.cxd.venus.encrypt.CryptoUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class AccountServiceImplTest {

    @Autowired
    private AccountService accountService;

    @Test
    void testAddAccount() {
        AccountBean accountbean = new AccountBean();
        accountbean.setAccountName("Account_1"+new Random().nextFloat());
        accountbean.setTenantId("DEFAULT");
        accountbean.setPassword(CryptoUtils.hashAlgorithm(ENCRYPT_TYPE.SHA256, "Account_1"));
        boolean flag = accountService.addAccount(accountbean);
        assertEquals(true, flag);
    }

    @Test
    void updateAccount() {
    }

    @Test
    void getAccountByAccountId() {
        Date date = new Date();

        Account account = accountService.getAccountByAccountId("Account_ID");
        System.out.println(new Date().getTime()- date.getTime());
        date = new Date();
        Account account1 = accountService.getAccountByAccountId("Account_ID");
        System.out.println(new Date().getTime()- date.getTime());
        date = new Date();
        Account account2 = accountService.getAccountByAccountId("Account_ID");
        System.out.println(new Date().getTime()- date.getTime());


        assertEquals("Account_Name", account.getAccountName());
    }

    @Test
    void getAccountByAccountName() {
        Account account = accountService.getAccountByAccountName("Account_Name");
        assertEquals("Account_ID", account.getAccountId());
    }

    @Test
    void delAccountByAccountId() {
    }

    @Test
    void delAccountByAccountName() {
    }

    @Test
    void destroyAccount() {
    }

    @Test
    void checkAccountNameAvailable() {
    }
}