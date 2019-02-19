package com.paytm.qapanel.service;

import com.paytm.qapanel.dbConnection;

import java.sql.*;

public class showTables {
    public static void main(String[] aqwsa) throws SQLException {
        dbConnection dbc=new dbConnection();
        Connection con=dbc.DBConnection("pgplusbo","staging");
        System.out.println("connection: "+con);
        DatabaseMetaData meta = con.getMetaData();
        ResultSet rs = meta.getTables(null, null, null,new String[] {"TABLE"});
        while (rs.next())
        {
            System.out.println(rs.getString("TABLE_NAME"));
        }
        //return rs;
    }
}
