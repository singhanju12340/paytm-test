package com.paytm.qapanel.model;

public class ExecuteSQL {
    public static void getFormValue(String db, String env, String operation, String sql_query)
    {
        //SQL_KEYWORD sql_keyword;
        System.out.println(db);
        System.out.println(env);
        System.out.println(operation);
        String quey_keyword= sql_query.substring(0,6);
        //for (enum myenum: SQL_KEYWORD.values())
        {
            //System.out.println(myenum);
        }
        //if(quey_keyword==sql_keyword.toString())
        {

        }
    }
}
 enum SQL_KEYWORD
{
    SELECT
}
