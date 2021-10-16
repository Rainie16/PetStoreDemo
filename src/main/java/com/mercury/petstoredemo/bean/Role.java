package com.mercury.petstoredemo.bean;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "Project_Role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String type;

    public Role() {
    }

    public Role(int id) {
        this.id = id;
    }

    public Role(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public String getAuthority() {
        return type;
    }
}
