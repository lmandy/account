package com.lmandy.bean;

/**
 * Created by 94993 on 2017/03/06
 */
public class AccountRecordFileRelation {

	private Integer id;
	private Integer fileId;
	private Integer recordId;

	public AccountRecordFileRelation() {
	}

	public AccountRecordFileRelation(Integer id, Integer fileId, Integer recordId) {
		this.id = id;
		this.fileId = fileId;
		this.recordId = recordId;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	@Override
	public String toString() {
		return "AccountRecordFileRelation{" +
				"id=" + id +
				", fileId=" + fileId +
				", recordId=" + recordId +
				'}';
	}
}