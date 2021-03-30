package com.cxd.venus.auth.service;

import com.cxd.venus.auth.bean.AccountBean;
import com.cxd.venus.auth.constant.STATUS;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 19:49
 * @Version 1.0
 **/
public interface AuthService {

    /**
     * 验证用户(租户)
     * @param accountName
     * @param tenantId
     * @param password
     * @return
     */
    boolean check(String accountName, String tenantId, String password);

    /**
     * 验证用户
     * @param accountId
     * @param password
     * @return
     */
    boolean checkWithoutTenant(String accountId, String password);

    /**
     * 验证失败后的检查
     * @param accountName
     * @param tenantId
     * @param password
     * @return
     */
    STATUS checkError(String accountName, String tenantId, String password);


}
