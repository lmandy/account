package com.lmandy.bean;

/**
 * Created by 94993 on 2017/03/12
 */
public class AccountUser {

	private Integer id;
	private String userName;
	private String passWord;
	private String token;
	private String portrait;
	private String createTime;

    public AccountUser() {
    }

    public AccountUser(Integer id, String userName, String passWord, String token, String portrait, String createTime) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.token = token;
        this.portrait = portrait;
        this.createTime = createTime;
    }

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "AccountUser{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", passWord='" + passWord + '\'' +
				", token='" + token + '\'' +
				", portrait='" + portrait + '\'' +
				", createTime='" + createTime + '\'' +
				'}';
	}
}