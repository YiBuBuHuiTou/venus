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
     * @param accountBean
     * @return
     */
    boolean check(AccountBean accountBean);

    /**
     * 验证用户
     * @param accountBean
     * @return
     */
    boolean checkWithoutTenant(AccountBean accountBean);

    /**
     * 验证失败后的检查
     * @param accountBean
     * @return
     */
    STATUS checkError(AccountBean accountBean);


}
