package com.paytm.qapanel.dao.entity;

import javax.persistence.*;

/**
 * Created by anjukumari on 18/01/19
 */

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    int user_id;
    String command;


    public int getId() {
        return id;
    }

    public History setId(int id) {
        this.id = id;
        return this;
    }

    public int getUser_id() {
        return user_id;
    }

    public History setUser_id(int user_id) {
        this.user_id = user_id;
        return this;
    }

    public String getCommand() {
        return command;
    }

    public History setCommand(String command) {
        this.command = command;
        return this;
    }
}
