package com.cxd.venus.auth.service.impl;

import com.cxd.venus.auth.bean.AuthBean;
import com.cxd.venus.auth.service.AuthService;
import org.springframework.stereotype.Service;

/**
 * @Author YiBuBuHuiTou
 * @Description
 * @Date 2021/3/10 20:04
 * @Version 1.0
 **/
@Service
public class AuthServiceImpl implements AuthService {


    /**
     * 验证用户
     *
     * @param authBean
     * @return
     */
    @Override
    public boolean check(AuthBean authBean) {
        return false;
    }

    /**
     * 验证用户
     *
     * @param authBean
     * @return
     */
    @Override
    public boolean checkWithoutTenant(AuthBean authBean) {
        return false;
    }

    /**
     * 验证失败后的检查
     *
     * @param authBean
     * @return
     */
    @Override
    public int checkError(AuthBean authBean) {
        return 0;
    }


}
