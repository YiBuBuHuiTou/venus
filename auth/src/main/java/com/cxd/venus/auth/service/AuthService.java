package com.cxd.venus.auth.service;

import com.cxd.venus.auth.bean.AuthBean;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 19:49
 * @Version 1.0
 **/
public interface AuthService {

    /**
     * 验证用户(租户)
     * @param authBean
     * @return
     */
    boolean check(AuthBean authBean);

    /**
     * 验证用户
     * @param authBean
     * @return
     */
    boolean checkWithoutTenant(AuthBean authBean);

    /**
     * 验证失败后的检查
     * @param authBean
     * @return
     */
    int checkError(AuthBean authBean);


}
