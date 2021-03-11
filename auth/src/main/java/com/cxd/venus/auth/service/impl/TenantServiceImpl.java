package com.cxd.venus.auth.service.impl;

import com.cxd.venus.auth.bean.AuthBean;
import com.cxd.venus.auth.service.TenantService;
import org.springframework.stereotype.Service;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 20:17
 * @Version 1.0
 **/
@Service
public class TenantServiceImpl implements TenantService {

    /**
     * 包装返回值
     *
     * @param invalidStatus
     * @param action
     * @return
     */
    @Override
    public AuthBean makeUpRes(boolean invalidStatus, int action) {
        return null;
    }
}
