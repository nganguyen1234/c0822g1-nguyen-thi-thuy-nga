package com.example.model;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    private String roleName;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int id) {
        this.roleId = id;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String name) {
        this.roleName = name;
    }

}
