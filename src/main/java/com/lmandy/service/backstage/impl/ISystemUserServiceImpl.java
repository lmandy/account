package com.lmandy.service.backstage.impl;

import com.lmandy.bean.AccountSystemUser;
import com.lmandy.dao.IBaseMapper;
import com.lmandy.dao.backstage.ISystemUserMapper;
import com.lmandy.service.IBaseService;
import com.lmandy.service.IBaseServiceImpl;
import com.lmandy.service.backstage.ISystemUserService;
import com.lmandy.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 94993 on 2017/2/27.
 */
@Service
public class ISystemUserServiceImpl extends IBaseServiceImpl<AccountSystemUser> implements ISystemUserService{

    @Autowired
    private ISystemUserMapper iSystemUserMapper;


    @Override
    public IBaseMapper getBaseMapper() {
        return iSystemUserMapper;
    }

    @Override
    public void indexInfo(PageBean<AccountSystemUser> pageBean) {
        super.indexInfo(pageBean);
    }
}
