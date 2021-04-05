package com.cxd.venus.auth.service.impl;

import com.cxd.venus.auth.bean.AccountBean;
import com.cxd.venus.auth.config.AppDefault;
import com.cxd.venus.auth.config.policy.AccountPolicy;
import com.cxd.venus.auth.dao.AccountRepository;
import com.cxd.venus.auth.entity.Account;
import com.cxd.venus.auth.service.AccountService;
import com.cxd.venus.constant.ENCRYPT_TYPE;
import com.cxd.venus.encrypt.CryptoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/11 22:04
 * @Version 1.0
 **/
@Service
@CacheConfig(cacheNames = "account_cache", cacheManager = "cacheManager")
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    private AppDefault appDefault;

    private AccountPolicy accountPolicy;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, AppDefault appDefault, AccountPolicy accountPolicy) {
        this.accountRepository = accountRepository;
        this.appDefault = appDefault;
        this.accountPolicy = accountPolicy;
    }

    /**
     * 追加账号
     * @param accountBean
     * @return
     */
    @Override
    public boolean addAccount(AccountBean accountBean) {
        Account account = new Account();

        //设置用户名
        String accountName = accountBean.getAccountName();
        Assert.hasText(accountName, "用户名为空");
        if (!accountPolicy.checkAccountName(null, accountName)) {
            return false;
        }
        account.setAccountName(accountName);

        //设置SHA256加密后的密码
        String password = accountBean.getPassword();
        if (!accountPolicy.checkPassword(null, password)) {
            return false;
        }
        account.setPassword(CryptoUtils.hashAlgorithm(ENCRYPT_TYPE.SHA256, password));

        //设置租户ID：默认ID "DEFAULT"
        String tenantId = accountBean.getTenantId();
        if(!StringUtils.hasText(tenantId)) {
            tenantId = appDefault.getDefaultTenant();
        }

        account.setTenantId(tenantId);

        //设置描述
        account.setDescription(accountBean.getDescription());

        //设置账号权限：初始权限：0
        if(accountBean.getPrivilege() == 0) {
            account.setPrivilege(appDefault.getDefaultPrivilege());
        } else {
            account.setPrivilege(accountBean.getPrivilege());
        }

        Account result = null;
        result = accountRepository.save(account);

        if (result == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 跟新账号
     *
     * @param accountBean
     * @return
     */
    @Override
    public boolean updateAccount(AccountBean accountBean) {
        String accountId = accountBean.getAccountId();
        String accountName = accountBean.getAccountName();
        String password = accountBean.getPassword();

        Account account = accountRepository.findAccountByAccountId(accountId);

        if (accountPolicy.checkAccountName(accountId, accountName)) {
            //TODO
            return false;
        }
        if (accountPolicy.checkPassword(accountId, password)) {
            //TODO
            return false;
        }
        account.setAccountName(accountName);
        account.setPassword(CryptoUtils.hashAlgorithm(ENCRYPT_TYPE.SHA256, password));
        // 更新账号
        accountRepository.save(account);
        return false;
    }

    /**
     * 查询账号
     *
     * @param accountId
     * @return
     */
    @Override
    @Cacheable(value = "account", key = "#accountId")
    public Account getAccountByAccountId(String accountId) {
        return accountRepository.findAccountByAccountId(accountId);
    }

    /**
     * 查询账号
     *
     * @param accountName
     * @return
     */
    @Override
    @Cacheable(value = "account", key = "#accountName")
    public Account getAccountByAccountName(String accountName) {
        return accountRepository.findAccountByAccountName(accountName);
    }

    /**
     * 删除账号
     *
     * @param accountId
     * @return
     */
    @Override
    @CacheEvict(value = "account", allEntries = true)
    public boolean delAccountByAccountId(String accountId) {
        //TODO
        return false;
    }

    /**
     * 删除账号
     *
     * @param accountName
     * @return
     */
    @Override
    @CacheEvict(value = "account", allEntries = true)
    public boolean delAccountByAccountName(String accountName) {
        // TODO
        return false;
    }

    /**
     * 销毁账号
     *
     * @param accountId
     * @return
     */
    @Override
    @CacheEvict(value = "account", allEntries = true)
    public boolean destroyAccount(String accountId) {
        accountRepository.deleteById(accountId);
        return false;
    }

    /**
     * check用户名是否有效
     *
     * @param accountName
     * @return
     */
    @Override
    public boolean checkAccountNameAvailable(String accountName) {
        return accountPolicy.checkAccountName(accountName);
    }
}
