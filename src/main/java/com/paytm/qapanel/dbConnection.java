package com.paytm.qapanel;
import java.sql.*;
public class dbConnection {
    public Statement DBConnection() {
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:5001/PGPDB";
            //String sql = "select * from BANK_MASTER where BANK_CODE='HDFC';";
            Connection con = DriverManager.getConnection(
                    url, "root", "root");
             stmt = con.createStatement();
            System.out.println(stmt.toString());
           //ResultSet rs = stmt.executeQuery(sql);
            //while (rs.next())
                //System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " " + rs.getString(4));
            //con.close();
            //System.out.println(" DB Connection Closed");
        } catch (Exception e) {
            System.out.println(e);
        }
        return stmt;
    }
}
