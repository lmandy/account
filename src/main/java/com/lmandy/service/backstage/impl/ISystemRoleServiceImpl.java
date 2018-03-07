package com.lmandy.service.backstage.impl;

import com.lmandy.bean.AccountSystemMenu;
import com.lmandy.bean.AccountSystemRole;
import com.lmandy.dao.IBaseMapper;
import com.lmandy.dao.backstage.ISystemRoleMapper;
import com.lmandy.service.IBaseServiceImpl;
import com.lmandy.service.backstage.ISystemRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liming<liming@1rock.net> on 2017/3/22.
 */
@Service
@Transactional
public class ISystemRoleServiceImpl extends IBaseServiceImpl<AccountSystemRole> implements ISystemRoleService {

    @Autowired
    private ISystemRoleMapper roleMapper;

    @Override
    public IBaseMapper<AccountSystemRole> getBaseMapper() {
        return roleMapper;
    }

    @Override
    public List<AccountSystemMenu> getByUserId(Integer userId) {

        List<AccountSystemMenu> menus = new ArrayList<>();

        List<AccountSystemMenu> menuList = roleMapper.getByUserId(userId);

        /**
         * 第一遍获取父级
         */
        for (AccountSystemMenu menu : menuList) {
            if(menu.getParentId() == -1){
                menus.add(menu);
            }
        }
        /**
         * 第二遍获取父级下的子路径
         */

        for (AccountSystemMenu pmenu : menus) {
            for (AccountSystemMenu cmenu : menuList) {
                if(pmenu.getId().equals(cmenu.getParentId())){
                    pmenu.getChildrenMenu().add(cmenu);
                }
            }
        }


        return menus;
    }

    /**
     * 获取用户的角色信息
     */
    @Override
    public List<AccountSystemRole> getRolesByUserId(Integer userId){
        return roleMapper.getRolesByUserId(userId);
    }
}
