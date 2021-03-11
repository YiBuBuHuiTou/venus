package com.cxd.venus.auth.service.impl;

import com.cxd.venus.auth.dao.AccountRepository;
import com.cxd.venus.auth.entity.Account;
import com.cxd.venus.auth.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/11 22:04
 * @Version 1.0
 **/
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean addAccount(Account account) {
        accountRepository.save(account);
        return true;
    }
}
