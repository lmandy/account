package com.lmandy.bean;

/**
 * Created by 94993 on 2017/03/06
 */
public class AccountRecordTeamRelation {

	private Integer id;
	private Integer recordId;
	private Integer teamId;

	public AccountRecordTeamRelation() {
	}

	public AccountRecordTeamRelation(Integer id, Integer recordId, Integer teamId) {
		this.id = id;
		this.recordId = recordId;
		this.teamId = teamId;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return "AccountRecordTeamRelation{" +
				"id=" + id +
				", recordId=" + recordId +
				", teamId=" + teamId +
				'}';
	}
}