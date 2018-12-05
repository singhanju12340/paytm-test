package com.paytm.qapanel.dao.entity;

import javax.persistence.*;

/**
 * Created by anjukumari on 04/12/18
 */

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String email;
    private String name;
    private String password;


    public User(String email,String name, String password) {
        super();
        this.email = email;
        this.name = name;
        this.password = password;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
        super();
    }

    public User(int id, String name, String password) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [id=").append(id).append(", email=").append(email).append(", name=").append(name)
                .append(", password=").append(password).append("]");
        return builder.toString();
    }
}
