package com.cxd.venus.auth.service.impl;

import com.cxd.venus.auth.bean.AccountBean;
import com.cxd.venus.auth.bean.TenantBean;
import com.cxd.venus.auth.dao.TenantRespository;
import com.cxd.venus.auth.entity.Tenant;
import com.cxd.venus.auth.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 20:17
 * @Version 1.0
 **/
@Service
public class TenantServiceImpl implements TenantService {

    private TenantRespository tenantRespository;

    @Autowired
    public TenantServiceImpl(TenantRespository tenantRespository) {
        this.tenantRespository = tenantRespository;
    }

    @Override
    public boolean addTenant(TenantBean tenantBean) {
        Tenant tenant = new Tenant();
        tenant.setTenantName(tenantBean.getTenantName());
        tenant.setStatus(tenantBean.getStatus());
        tenant.setOwner(tenantBean.getOwner());
        tenant.setDescription(tenantBean.getDescription());
        //TODO check
        if (tenantRespository.save(tenant) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean checkTenantExists(String tennatName) {
        boolean existFlag = false;
        existFlag = tenantRespository.existsTenantByTenantName(tennatName);
        return existFlag;
    }

    @Override
    public boolean delTenant(String tenantId, String tennatUser) {
        return false;
    }

    @Override
    public boolean updateTenant(TenantBean tenantBean) {
        return false;
    }
}
