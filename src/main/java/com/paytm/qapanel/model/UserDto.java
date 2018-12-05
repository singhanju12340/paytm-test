package com.paytm.qapanel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by anjukumari on 05/12/18
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private int id;
    private String name;
    private String password;
    private String email;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
