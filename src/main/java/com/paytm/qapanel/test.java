package com.paytm.qapanel;

public class test {
    public static void main(String [] abc)
    {
        String sql="update BANK_MASTER set BANK_NAME='HDFC BANK' where BANK_CODE='HDFC'";
        String Str = new String(sql);
        System.out.println(Str.replace("'", "\"+\""));
        //System.out.println(sql);
    }
}
