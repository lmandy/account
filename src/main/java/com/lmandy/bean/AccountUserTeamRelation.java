package com.lmandy.bean;

/**
 * Created by 94993 on 2017/03/06
 */
public class AccountUserTeamRelation {

	private Integer id;
	private Integer userId;
	private Integer teamId;
	private Integer sign;
	private Integer delSign;

	private String name; //群组名称
	private String userName;// 用户名称

	public AccountUserTeamRelation() {
	}

	public AccountUserTeamRelation(Integer id, Integer userId, Integer teamId, Integer sign) {
		this.id = id;
		this.userId = userId;
		this.teamId = teamId;
		this.sign = sign;
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
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Integer getSign() {
		return sign;
	}

	public void setSign(Integer sign) {
		this.sign = sign;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getDelSign() {
		return delSign;
	}

	public void setDelSign(Integer delSign) {
		this.delSign = delSign;
	}

	@Override
	public String toString() {
		return "AccountUserTeamRelation{" +
				"id=" + id +
				", userId=" + userId +
				", teamId=" + teamId +
				", sign=" + sign +
				", name='" + name + '\'' +
				", userName='" + userName + '\'' +
				'}';
	}
}