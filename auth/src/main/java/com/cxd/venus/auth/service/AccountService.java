package com.cxd.venus.auth.service;

import com.cxd.venus.auth.bean.AccountBean;
import com.cxd.venus.auth.entity.Account;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/11 22:04
 * @Version 1.0
 **/
public interface AccountService {

    /**
     * 追加账号
     * @param accountBean
     * @return
     */
    boolean addAccount(AccountBean accountBean);

    /**
     * 跟新账号
     * @param accountBean
     * @return
     */
    boolean updateAccount(AccountBean accountBean);

    /**
     * 查询账号
     * @param accountId
     * @return
     */
    Account getAccountByAccountId(String accountId);

    /**
     * 查询账号
     * @param accountName
     * @return
     */
    Account getAccountByAccountName(String accountName);

    /**
     * 删除账号
     * @param accountId
     * @return
     */
    boolean delAccountByAccountId(String accountId);

    /**
     * 删除账号
     * @param accountName
     * @return
     */
    boolean delAccountByAccountName(String accountName);

    /**
     * 销毁账号
     * @param accountId
     * @return
     */
    boolean destroyAccount(String accountId);

    /**
     * check用户名是否有效
     * @param accountName
     * @return
     */
    boolean checkAccountNameAvailable(String accountName);


}
