package com.cxd.venus.auth.service.impl;

import com.cxd.venus.auth.bean.AccountBean;
import com.cxd.venus.auth.config.AppDefault;
import com.cxd.venus.auth.dao.AccountRepository;
import com.cxd.venus.auth.entity.Account;
import com.cxd.venus.auth.service.AccountService;
import com.cxd.venus.constant.ENCRYPT_TYPE;
import com.cxd.venus.encrypt.CryptoUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    private AppDefault appDefault;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, AppDefault appDefault) {
        this.accountRepository = accountRepository;
        this.appDefault = appDefault;
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
        account.setAccountName(accountName);

        //设置SHA256加密后的密码
        String password = accountBean.getPassword();
        //TODO 判断密码强度策略
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
        account.setPrivilege(appDefault.getDefaultPrivilege());

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
        return false;
    }

    /**
     * 查询账号
     *
     * @param accountId
     * @return
     */
    @Override
    public boolean getAccountByAccountId(String accountId) {
        return false;
    }

    /**
     * 查询账号
     *
     * @param accountName
     * @return
     */
    @Override
    public boolean getAccountByAccountName(String accountName) {
        return false;
    }

    /**
     * 删除账号
     *
     * @param accountId
     * @return
     */
    @Override
    public boolean delAccountByAccountId(String accountId) {
        return false;
    }

    /**
     * 删除账号
     *
     * @param accountName
     * @return
     */
    @Override
    public boolean delAccountByAccountName(String accountName) {
        return false;
    }

    /**
     * 销毁账号
     *
     * @param accountId
     * @return
     */
    @Override
    public boolean destroyAccount(String accountId) {
        return false;
    }
}
