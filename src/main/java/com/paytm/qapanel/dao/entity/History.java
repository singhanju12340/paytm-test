package com.paytm.qapanel.dao.entity;

import net.bytebuddy.implementation.bytecode.constant.DefaultValue;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

import static java.time.LocalDateTime.now;

/**
 * Created by anjukumari on 18/01/19
 */

@Entity
@Table(name = "user_sql_history")
public class History {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    int user_id;
    String command;
    String env;
    String database;
    @Column(columnDefinition="default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP")

    Time date;

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public Time getDate() {
        return date;
    }

    public void setDate(Time date) {
        this.date = date;
    }

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
