package com.cxd.venus.auth.dao;

import com.cxd.venus.auth.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/11 20:31
 * @Version 1.0
 **/
public interface TenantRespository extends JpaRepository<Tenant, String> {

    /**
     * 根据tennatId查询
     * @param tenantId
     * @return
     */
    Tenant findTenantByTenantId(String tenantId);

    /**
     * 根据tenant名查询
     * @param tenantName
     * @return
     */
    Tenant findTenantByTenantName(String tenantName);

    /**
     * 根据所属者查询
     * @param accountId
     * @return
     */
    List<Tenant> findTenantsByOwner(String accountId);

}
