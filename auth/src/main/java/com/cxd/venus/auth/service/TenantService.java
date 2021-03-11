package com.cxd.venus.auth.service;

import com.cxd.venus.auth.bean.AuthBean;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 20:11
 * @Version 1.0
 **/
public interface TenantService {

    /**
     * 包装返回值
     * @param invalidStatus
     * @param action
     * @return
     */
    AuthBean makeUpRes(boolean invalidStatus, int action);
}
