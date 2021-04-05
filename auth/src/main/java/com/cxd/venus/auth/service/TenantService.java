package com.cxd.venus.auth.service;

import com.cxd.venus.auth.bean.AccountBean;
import com.cxd.venus.auth.bean.TenantBean;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 20:11
 * @Version 1.0
 **/
public interface TenantService {

    boolean addTenant(TenantBean tenantBean);

    boolean delTenant(String tenantId, String tennatUser);

    boolean updateTenant(TenantBean tenantBean);

    boolean checkTenantExists(String tennatName);
}
