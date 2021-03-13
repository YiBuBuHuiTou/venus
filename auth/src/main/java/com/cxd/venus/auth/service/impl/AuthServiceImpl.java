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
     * @param authBean
     * @return
     */
    @Override
    public boolean check(AccountBean authBean) {
        boolean checkRes = false;
        String accountName = authBean.getAccountName();
        Assert.hasText(accountName, "用户名输入为空");
        String tenantId = authBean.getTenantId();
        Assert.hasText(tenantId, "租户为空");
        String password = authBean.getPassword();
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
     * @param authBean
     * @return
     */
    @Override
    public boolean checkWithoutTenant(AccountBean authBean) {
        boolean checkRes = false;
        String accountName = authBean.getAccountName();
        Assert.hasText(accountName, "用户名输入为空");
        String password = authBean.getPassword();
        String passForSHA256 = CryptoUtils.hashAlgorithm(ENCRYPT_TYPE.SHA256, password);
        Account account = accountRepository.findAccountByAccountNameAndPassword(accountName, passForSHA256);
        if (account != null) {
            checkRes = true;
        }
        return checkRes;
    }

    /**
     * 验证失败后的检查
     *
     * @param authBean
     * @return
     */
    @Override
    public STATUS checkError(AccountBean authBean) {
        String accountName = authBean.getAccountName();
        Assert.hasText(accountName,"用户名输入为空");

        Account account = null;
        account = accountRepository.findAccountByAccountName(accountName);
        if (account == null) {
            return STATUS.ACCOUNT_NOT_FOUND;
        }
        if (checkWithoutTenant(authBean)) {
            return STATUS.PASSWORD_NOT_MATCH;
        }
        if (check(authBean)) {
            return STATUS.TENANT_NOT_FOUND;
        }
        return STATUS.DEFAULT;
    }

}
