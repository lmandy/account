package com.lmandy.bean;

import java.util.List;

/**
 * Created by 94993 on 2017/03/06
 */
public class AccountRecord {

	private Integer id;
	private Double money;
	private String remarks;
	private Integer userId;
	private String userName;
	private Integer sigle;
	private String createTime;

	private List<AccountFile> recordFiles;

	public AccountRecord() {
	}

	public AccountRecord(Integer id, Double money, String remarks, Integer userId, Integer sigle,String createTime) {
		this.id = id;
		this.money = money;
		this.remarks = remarks;
		this.userId = userId;
		this.sigle = sigle;
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getSigle() {
		return sigle;
	}
	public void setSigle(Integer sigle) {
		this.sigle = sigle;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<AccountFile> getRecordFiles() {
		return recordFiles;
	}

	public void setRecordFiles(List<AccountFile> recordFiles) {
		this.recordFiles = recordFiles;
	}

	@Override
	public String toString() {
		return "AccountRecord{" +
				"id=" + id +
				", money=" + money +
				", remarks='" + remarks + '\'' +
				", userId=" + userId +
				", sigle=" + sigle +
				", createTime=" + createTime +
				'}';
	}
}