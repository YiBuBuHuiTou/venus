package com.cxd.venus.auth.dao;

import com.cxd.venus.auth.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/11 20:19
 * @Version 1.0
 **/
public interface AccountRepository extends JpaRepository<Account, String> {

    /**
     * 根据UUID查询
     * @param accountId
     * @return
     */
    Account findAccountByAccountId(String accountId);

    /**
     * 根据用户Id查询
     * @param accountName
     * @return
     */
    Account findAccountByAccountName(String accountName);

    /**
     *根据租户Id查询
     * @param tenantId
     * @return
     */
    List<Account> findAccountsByTenantId(String tenantId);

    /**
     * 根据秘钥查询
     * @param securityKey
     * @return
     */
    Account findAccountBySecurityKey(String securityKey);


    /**
     * 根据用户名和密码查询结果
     * @param accountName
     * @param password
     * @return
     */
    Account findAccountByAccountNameAndPassword(String accountName, String password);

    /**
     * 根据用户名和密码和租户名查询结果
     * @param accountName
     * @param tenantId
     * @param password
     * @return
     */
    Account findAccountByAccountNameAndTenantIdAndPassword(String accountName, String tenantId, String password);
}
