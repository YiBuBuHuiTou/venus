package com.cxd.venus.auth.service.impl;

import com.cxd.venus.auth.bean.AuthBean;
import com.cxd.venus.auth.dao.AccountRepository;
import com.cxd.venus.auth.entity.Account;
import com.cxd.venus.auth.service.AuthService;
import com.cxd.venus.constant.ENCRYPT_TYPE;
import com.cxd.venus.encrypt.CryptoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean check(AuthBean authBean) {
        boolean checkRes = false;
        String accountName = authBean.getAccountName();
        String tenantId = authBean.getTenantId();
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
    public boolean checkWithoutTenant(AuthBean authBean) {
        return false;
    }

    /**
     * 验证失败后的检查
     *
     * @param authBean
     * @return
     */
    @Override
    public int checkError(AuthBean authBean) {
        return 0;
    }


}
