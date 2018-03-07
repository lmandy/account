package com.lmandy.bean;

/**
 * Created by 94993 on 2017/03/07
 */
public class AccountTeam {

	private Integer id;
	private String name;
	private String createTime;
	private Integer userId;

	public AccountTeam() {
	}

	public AccountTeam(Integer id, String name, String createTime) {
		this.id = id;
		this.name = name;
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "AccountTeam{" +
				"id=" + id +
				", name='" + name + '\'' +
				", userId=" + userId +
				", createTime='" + createTime + '\'' +
				'}';
	}
}