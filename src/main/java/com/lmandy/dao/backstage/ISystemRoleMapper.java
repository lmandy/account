package com.lmandy.dao.backstage;

import com.lmandy.bean.AccountSystemMenu;
import com.lmandy.bean.AccountSystemRole;
import com.lmandy.dao.IBaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 94993 on 2017/2/26.
 */
@Repository
public interface ISystemRoleMapper extends IBaseMapper<AccountSystemRole> {
    /**
     * 获取用户角色下的权限
     * @param userId
     * @return
     */
    List<AccountSystemMenu> getByUserId(Integer userId);

    /**
     * 获取用户的角色信息
     * @param userId
     * @return
     */
    List<AccountSystemRole> getRolesByUserId(Integer userId);
}
