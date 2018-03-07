package com.lmandy.bean;

/**
 * Created by 94993 on 2017/03/22
 */
public class AccountSystemUserRole {

	private Integer id;
	private Integer userId;
	private Integer roleId;

	public AccountSystemUserRole() {
	}

	public AccountSystemUserRole(Integer id, Integer userId, Integer roleId) {
		this.id = id;
		this.userId = userId;
		this.roleId = roleId;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "AccountSystemUserRole{" +
				"id=" + id +
				", userId=" + userId +
				", roleId=" + roleId +
				'}';
	}
}