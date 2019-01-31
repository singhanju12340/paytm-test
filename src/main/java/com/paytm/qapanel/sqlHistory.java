package com.paytm.qapanel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class sqlHistory {
    //user_id,operation_type,sql_query,environment,used_database,date
    static dbConnection ipcon=new dbConnection();
    public  void user_sql_history( String usersql, String operation_type, String environment, String used_database) throws SQLException, ClassNotFoundException {
        //String user_id, operation_type, sql_query, environment = null, used_database = null, date;
        // Create DB connection


            Connection dbcon=null;
            try {
                for(Map.Entry<String, Connection> entry: ipcon.env_map.entrySet())
                {
                    if(entry.getKey().equals("staging_mydatabase"))
                    {
                        dbcon=ipcon.env_map.get("staging_mydatabase");
                        System.out.println("sqlcon obj is present");
                        if(dbcon.isClosed())
                        {
                            ipcon.env_map.remove("staging_mydatabase");
                            dbcon=null;
                        }
                        System.out.println("old connection obj");
                        break;
                    }
                }
                if(dbcon==null) {
                    Class.forName("com.mysql.jdbc.Driver");
                    dbcon = DriverManager.getConnection("jdbc:mysql://"  +ipcon.con_ip().get("staging").toString()+ "/" + "mydatabase", "root", "root");
                    ipcon.env_map.put("staging_mydatabase", dbcon);
                }

            Statement smt=dbcon.createStatement();
            String insertsql="insert into user_sql_history(user_id,operation_type,sql_query,environment,used_database,date)" +
                    " values('001','"+operation_type+"',\""+usersql+"\",'"+environment+"','"+used_database+"',now())";
                System.out.println("sql in sqlhistory"+insertsql);
                smt.executeUpdate(insertsql);
            }
            catch (Exception e) {
                System.out.println(e);
            }



    }
    }



