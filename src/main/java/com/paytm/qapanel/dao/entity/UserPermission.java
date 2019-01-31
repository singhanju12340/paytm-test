package com.paytm.qapanel.dao.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paytm.qapanel.model.Permission;

import javax.persistence.*;

/**
 * Created by anjukumari on 25/12/18
 */
@Entity
@Table(name = "user_permission")
public class UserPermission {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name="user_id")
    private String userId;
    private String permission;

    public UserPermission() {
    }

    public UserPermission(int id, String userId, Permission permission) {
        this.id = id;
        this.userId = userId;

        this.permission = permission.toString();
    }

    public UserPermission( String userId, String permission) {
        this.userId = userId;

        this.permission = permission;
    }

    public String getPermission(){
        return this.permission;
    }


}
