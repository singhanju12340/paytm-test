package com.paytm.qapanel;
import java.sql.*;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
public class dbConnection {
    static HashMap<String, Connection> env_map = new HashMap<>();
    public Connection DBConnection(String dbName,String environment)
    {
        Connection con=null;
        try {
            for(Entry<String, Connection> entry: env_map.entrySet())
            {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                if(entry.getKey().equals(environment+"_"+dbName))
                {
                    con=env_map.get(environment+"_"+dbName);
                    if(con.isClosed())
                    {
                        env_map.remove(environment+"_"+dbName);
                        con=null;
                    }
                    System.out.println("old connection obj");
                    break;
                }
            }
            if(con==null) {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println(dbName);
                System.out.println(environment);
                con = DriverManager.getConnection(
                        "jdbc:mysql://" + con_ip().get(environment).toString() + "/" + dbName, "root", "root");
                env_map.put(environment + "_" + dbName, con);
                System.out.println(env_map.toString() + "   " + env_map.size());
                System.out.println("New connection obj");
            }
        }
         catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public HashMap con_ip() throws IOException {

        FileReader reader=new FileReader("/Users/mainishmishra/Automation_Repo/paytm-test/src/main/resources/application.properties");
        Properties p=System.getProperties();
        p.load(reader);
        HashMap<String, String> value_from_file=new HashMap<>();
        for (final Entry<Object, Object> entry : p.entrySet()) {
            value_from_file.put((String) entry.getKey(), (String) entry.getValue());
        }
        //System.out.println(value_from_file.toString());
        //for (int i =0; i< value_from_file.size();i++)
        {
        }
        HashMap<String, String> con_map = new HashMap<>();
        con_map.put("staging", value_from_file.get("Staging_IP"));
        con_map.put("ite",value_from_file.get("Ite_IP"));
        con_map.put("hotfix", value_from_file.get("Hotfix_IP"));
        con_map.put("pos", value_from_file.get("Pos_IP"));
        con_map.put("qa5", value_from_file.get("Qa5_IP"));
        con_map.put("qa6", value_from_file.get("Qa6_IP"));
        con_map.put("qA7", value_from_file.get("Qa7_IP"));
        con_map.put("automation", value_from_file.get("Automation_IP"));
        return con_map;
    }
}
