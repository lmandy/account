package com.lmandy.bean;

/**
 * Created by 94993 on 2017/03/22
 */
public class AccountSystemRoleMenu {

	private Integer id;
	private Integer roleId;
	private Integer menuId;

	public AccountSystemRoleMenu() {
	}

	public AccountSystemRoleMenu(Integer id, Integer roleId, Integer menuId) {
		this.id = id;
		this.roleId = roleId;
		this.menuId = menuId;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		return "AccountSystemRoleMenu{" +
				"id=" + id +
				", roleId=" + roleId +
				", menuId=" + menuId +
				'}';
	}
}