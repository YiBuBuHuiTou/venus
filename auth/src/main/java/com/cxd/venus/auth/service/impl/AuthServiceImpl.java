package com.cxd.venus.auth.service.impl;

import com.cxd.venus.auth.bean.AccountBean;
import com.cxd.venus.auth.constant.STATUS;
import com.cxd.venus.auth.dao.AccountRepository;
import com.cxd.venus.auth.entity.Account;
import com.cxd.venus.auth.service.AuthService;
import com.cxd.venus.constant.ENCRYPT_TYPE;
import com.cxd.venus.encrypt.CryptoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 20:04
 * @Version 1.0
 **/
@Service
public class AuthServiceImpl implements AuthService {

    private AccountRepository accountRepository;


    @Autowired
    public AuthServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * 验证用户
     *
     * @param accountName
     * @param tenantId
     * @param password
     * @return
     */
    @Override
    public boolean check(String accountName, String tenantId, String password) {
        boolean checkRes = false;
        Assert.hasText(accountName, "用户名输入为空");
        Assert.hasText(tenantId, "租户为空");
        String passForSHA256 = CryptoUtils.hashAlgorithm(ENCRYPT_TYPE.SHA256, password);
        Account account = accountRepository.findAccountByAccountNameAndTenantIdAndPassword(accountName, tenantId, passForSHA256);
        if (account != null) {
            checkRes = true;
        }
        return checkRes;
    }

    /**
     * 验证用户
     *
     * @param accountId
     * @param password
     * @return
     */
    @Override
    public boolean checkWithoutTenant(String accountId, String password) {
        boolean checkRes = false;
        Assert.hasText(accountId, "用户名Id为空");
        String passForSHA256 = CryptoUtils.hashAlgorithm(ENCRYPT_TYPE.SHA256, password);
        if (accountRepository.existsAccountByAccountIdAndPassword(accountId, password)) {
            checkRes = true;
        }
        return checkRes;
    }

    /**
     * 验证失败后的检查
     *
     * @param accountName
     * @param tenantId
     * @param password
     * @return
     */
    @Override
    public STATUS checkError(String accountName, String tenantId, String password) {
        Assert.hasText(accountName,"用户名为空");

        if (!accountRepository.existsAccountByAccountName(accountName)) {
            return STATUS.ACCOUNT_NOT_FOUND;
        }
        if (checkWithoutTenant(accountName, password)) {
            return STATUS.PASSWORD_NOT_MATCH;
        }
        if (check(accountName, tenantId, password)) {
            return STATUS.TENANT_NOT_FOUND;
        }
        return STATUS.DEFAULT;
    }

}
