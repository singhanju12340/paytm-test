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
    private int userId;
    private String permission;

    public UserPermission( int userId, Permission permission) {
        this.userId = userId;
        this.permission = permission.toString();
    }

    public String getPermission(){
        return this.permission;
    }


}
