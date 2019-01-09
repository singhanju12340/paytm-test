package com.paytm.qapanel.model;

import java.util.ArrayList;

/**
 * Created by anjukumari on 24/12/18
 */
public class Permission {

    private ArrayList<String> environment;
    private String panelPermission;
    private String dbPermission;

    public Permission(){
        environment = new ArrayList<>();
        environment.add("all");
        panelPermission = "read";
        dbPermission = "read";
    }

    public Permission(ArrayList<String> environment, String panelPermission, String dbPermission) {
        this.environment = environment;
        this.panelPermission = panelPermission;
        this.dbPermission = dbPermission;
    }

    public ArrayList<String> getEnvironment() {
        return environment;
    }

    public Permission setEnvironment(ArrayList<String> environment) {
        this.environment = environment;
        return this;
    }

    public String getPanelPermission() {
        return panelPermission;
    }

    public Permission setPanelPermission(String panelPermission) {
        this.panelPermission = panelPermission;
        return this;
    }

    public String getDbPermission() {
        return dbPermission;
    }

    public Permission setDbPermission(String dbPermission) {
        this.dbPermission = dbPermission;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "environment=" + environment +
                ", panelPermission='" + panelPermission + '\'' +
                ", dbPermission='" + dbPermission + '\'' +
                '}';
    }
}
