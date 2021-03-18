package com.cxd.venus.auth.config.policy;

import com.cxd.venus.auth.dao.AccountRepository;
import com.cxd.venus.auth.entity.Account;
import com.cxd.venus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/14 20:43
 * @Version 1.0
 **/
@Service
public class AccountPolicy {

    private AccountRepository accountRepository;

    @Autowired
    public AccountPolicy(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * 用户名策略
     * @param accountId
     * @param accountName
     * @return
     */
    public boolean checkAccountName(String accountId, String accountName) {
        boolean active = true;
        if (!checkAccountName(accountName)) {
            active =  false;
        }
        if (!StringUtils.isEmpty(accountId)) {
            //判断用户名不是自己本名并且用户已存在则为无效用户名
            if (!accountRepository.existsAccountByAccountIdAndAccountName(accountId, accountName) &&
                    accountRepository.existsAccountByAccountName(accountName)) {
                active =  false;
            }
        }
        return active;
    }

    public boolean checkAccountName(String accountName) {
        if (StringUtils.isEmpty(accountName) || accountName.length() > 32) {
            return false;
        }
        return true;
    }

    /**
     * 密码策略
     * @param accountId
     * @param password
     * @return
     */
    public  boolean checkPassword(String accountId, String password){
        //TODO
        return true;
    }
}
