package com.lmandy.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 94993 on 2017/03/22
 */
public class AccountSystemMenu implements Serializable{

	private Integer id;
	private String menuName;
	private String menuUrl;
	private Integer parentId;

	private List<AccountSystemMenu> childrenMenu = new ArrayList<>();

    public AccountSystemMenu() {
    }

    public AccountSystemMenu(Integer id, String menuName, String menuUrl, Integer parentId) {
        this.id = id;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.parentId = parentId;
    }

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

    @Override
    public String toString() {
        return "AccountSystemMenu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", parentId=" + parentId +
                '}';
    }

	public List<AccountSystemMenu> getChildrenMenu() {
		return childrenMenu;
	}

	public void setChildrenMenu(List<AccountSystemMenu> childrenMenu) {
		this.childrenMenu = childrenMenu;
	}
}