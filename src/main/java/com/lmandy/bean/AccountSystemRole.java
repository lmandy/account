package com.lmandy.bean;

/**
 * Created by liming<liming@1rock.net> on 2017/3/22.
 */
public class AccountSystemRole {

    private Integer id;
    private String roleName;

    public AccountSystemRole() {
    }

    public AccountSystemRole(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AccountSystemRole{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
