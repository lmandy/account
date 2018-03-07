package com.lmandy.bean;

/**
 * Created by 94993 on 2017/03/06
 */
public class AccountFile {

	private Integer id;
	private String name;
	private Double size;
	private String path;
	private String token;
	private String createTime;

	public AccountFile() {
	}

	public AccountFile(Integer id, String name, Double size, String path, String token, String createTime) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.path = path;
		this.token = token;
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
	public Double getSize() {
		return size;
	}
	public void setSize(Double size) {
		this.size = size;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "AccountFile{" +
				"id=" + id +
				", name='" + name + '\'' +
				", size=" + size +
				", path='" + path + '\'' +
				", token='" + token + '\'' +
				", createTime='" + createTime + '\'' +
				'}';
	}
}