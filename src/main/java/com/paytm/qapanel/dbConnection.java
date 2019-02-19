package com.paytm.qapanel;

import java.sql.*;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class dbConnection {
    static HashMap<String, Connection> env_map = new HashMap<>();
    Connection con = null;
    public Connection DBConnection(String dbName, String environment) {

        try {

            for (Entry<String, Connection> entry : env_map.entrySet()) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                if (entry.getKey().equals(environment + "_" + dbName)) {
                    con = env_map.get(environment + "_" + dbName);
                    if (con.isClosed()) {
                        env_map.remove(environment + "_" + dbName);
                        con = null;
                    }
                    System.out.println("old connection obj");
                    break;
                }
            }
            if (con == null) {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println(dbName);
                System.out.println(environment);
                con = DriverManager.getConnection(
                        "jdbc:mysql://" + con_ip().get(environment).toString() + "/" + dbName, "root", "root");
                env_map.put(environment + "_" + dbName, con);
                System.out.println(env_map.toString() + "   " + env_map.size());
                System.out.println("New connection obj");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public HashMap con_ip() throws IOException {

        FileReader reader = new FileReader("/Users/mainishmishra/Automation_Repo/paytm-test/src/main/resources/environment.properties");
        Properties p = System.getProperties();
        p.load(reader);

        HashMap<String, String> value_from_file = new HashMap<>();
        for (final Entry<Object, Object> entry : p.entrySet())
        {

            if(entry.getKey().toString().trim().startsWith("IP"))
            {
                value_from_file.put((String) entry.getKey().toString().substring(3), (String) entry.getValue());
                }
        }
        System.out.println(value_from_file);
        return value_from_file;
    }

    // Function for Fetch all tables from DB
    public ResultSet alltables() throws SQLException {
        System.out.println("connection: " + con);
        DatabaseMetaData meta = con.getMetaData();
        ResultSet rs = meta.getTables(null, null, null, new String[]{"TABLE"});
        return rs;
    }
}
