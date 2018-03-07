package com.lmandy.service.backstage;

import com.lmandy.bean.AccountSystemMenu;
import com.lmandy.bean.AccountSystemRole;
import com.lmandy.service.IBaseService;

import java.util.List;

/**
 * Created by liming<liming@1rock.net> on 2017/3/22.
 */
public interface ISystemRoleService extends IBaseService<AccountSystemRole>{

    /**
     * 获取用户角色下的权限
     * @param userId
     * @return
     */
    List<AccountSystemMenu> getByUserId(Integer userId);

    /**
     * 获取用户的角色信息
     */
    List<AccountSystemRole> getRolesByUserId(Integer userId);

}
