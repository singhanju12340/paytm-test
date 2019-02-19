<%@ page import="com.paytm.qapanel.*" %>
<%@ page import="pageNumber.*, java.util.*, java.io.*" %>
<%@ page import ="java.sql.*"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" href="css/basic.css">
<script src="js/validation.js" type="text/javascript"></script>

</head>
<body>

<form action="/dashboard" method="POST">
<div id="page_div" name="page_div" class="page_div">
<div id="main_header_div" name="main_header_div" class="main_header_div">
<div id="dashbord_div" name="dashbord_div" class="dashbord_div">
<a href="dashbord.html">Dashbord</a>
</div>
<div id="user_div" name="user_div" class="user_div">
<a href="users.jsp">USERS</a>
</div>
<div id="permission_div" name="permission_div" class="permission_div">
<a href="permission.html">
Permission
</a></div>
<div id="environment_div" name="environment_div" class="environment_div">
<a href="environment.html">Environment</a></div>
<div id="environment_div" name="environment_div" class="environment_div">Example</div>
</div>
<div id="list_div" name="list_div" class="list_div">
<label for="Database">Database:</label>
<select name="database" id="database" name="database">
  <option value="select">Select</option>
  <option value="PAYTMPGDB">PAYTMPGDB</option>
  <option value="PGPDB">PGPDB</option>
  <option value="pgplusbo">pgplusbo</option>
</select>
<label for="Environment">Environment:</label>
            <select name="environment" id="environment">
            <option value="select">Select</option>
<%
try{
updateProperty up=new updateProperty();
Properties p = up.getProperty();
for (final Map.Entry<Object, Object> entry : p.entrySet())
    {
          if(entry.getKey().toString().trim().startsWith("IP"))
            {
   %>
   <option value=<%= entry.getKey().toString().substring(3) %>><%= entry.getKey().toString().substring(3) %></option>
  <% }}}
   catch(Exception e) {System.out.println(e);}%>
   </select>
  <label for="Operation">Operation:</label>
  <select name="operation" id="operation">
  <option value="SELECT">SELECT</option>
  <option value="UPDATE">UPDATE</option>
  <option value="INSERT">INSERT</option>
  <option value="ALTER">ALTER</option>
  <option value="DELETE">DELETE</option>
  <option value="CREATE">CREATE</option>
  <option value="DROP">DROP</option>
  <option value="SHOW_TABLES">Show Tables</option>
</select>
</div>
<div id="text_area_div" class="text_area_div">
<textarea rows="8" cols="100" name="query_text" id="query_text">
</textarea>
</div>
<div id="button_div" class="button_div">
<input type="Submit" value="Submit" onclick="Validate()">
<input type="reset" value="Clear">
</div>
<%
String database = request.getParameter("database");
String environment= request.getParameter("environment");
String operation_type = request.getParameter("operation");
String sql_query=request.getParameter("query_text");
String sql_query_trim="",sql_query_subs="",sql_query_upper="";
com.paytm.qapanel.dbConnection dbc=new dbConnection();
//ResultSet rs;
Statement stmt;
try
{
if(operation_type.equals("SHOW_TABLES"))
    {
    //out.println("operation type=show tables;");
    sql_query="SHOW_TABLES";
    sql_query_upper="SHOW_TABLES";
    }
if(sql_query==null){}
else
{
   if(sql_query!=null)
   {
   //out.println("sql is not null "+sql_query);
   sql_query_trim=sql_query.trim();
   sql_query_subs=sql_query_trim.substring(0,6);
   sql_query_upper=sql_query_subs.toUpperCase();

  if(operation_type.equals(sql_query_upper) || operation_type.equals("SHOW_TABLES"))
  {
  //out.println(" if to check select or show ");
     if(database!=null || environment!=null || operation_type!=null)
     {

     Connection con=dbc.DBConnection(database, environment);
    Statement smt=con.createStatement();

    if(operation_type.equals("SHOW_TABLES"))
        {
        //out.println(" if to check for show tables    ");
        ResultSet rs = dbc.alltables();

        %>
        <table border=1>
        <tr>
        <%
        int i=1;
        while(rs.next()){
        %><td><%= i%></td><td name=<%= rs.getString("TABLE_NAME")%>><%= rs.getString("TABLE_NAME")%></td></tr><%

           i++; }

            %></table><%
        }


    if(sql_query_upper.equals("SELECT"))
    {
    //out.println("  if for select   ");
    ResultSet rs=smt.executeQuery(sql_query);
    int colCount= rs.getMetaData().getColumnCount();
     %>
           <table border=1 width=100%>

           <tr width=100%>
           <%
           ResultSetMetaData rsmd = rs.getMetaData();
               for (int i = 1; i <=colCount; i++ ) {
                 %>
                 <td width=50px><%= rsmd.getColumnName(i)%></td>
                 <%
                 }%></tr>
                 <%
     while(rs.next())
     {
        %>
        <tr width=100%>
        <%
       for(int r=1;r<=colCount;r++)
       {
       %>
       <td width=50px><%= rs.getString(r) %></td>
              <%}%>
       </tr>
    <%
    }
    %></table><%
    }
    else if(operation_type.equals("INSERT") || operation_type.equals("UPDATE") || operation_type.equals("ALTER") ||operation_type.equals("DELETE") ||operation_type.equals("CREATE"))
             {
             System.out.println("operation in else if: "+sql_query);
             int i=smt.executeUpdate(sql_query);
             if (i > 0)
             {
                 sqlHistory sqlhistoryobj=new sqlHistory();
                 sqlhistoryobj.user_sql_history(sql_query,sql_query_upper,environment,database);
             } else
             {
              System.out.println("Opertation Unsuccessfull...!");
             }

             }
    }
    }
  }
  else
  {
    out.println("Operation not permitted.");
  }
 }
}
catch(Exception e)
{
out.println(e);}
%>
</form>
</body>

<%

%>


</html>
