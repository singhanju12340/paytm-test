<%@ page import="com.paytm.qapanel.model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.paytm.qapanel.service.*"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" href="css/basic.css">
<script src="js/validation.js" type="text/javascript"></script>
</head>
<body>
<%name = request.getParameter("user_name"); %>
<%!
ArrayList<String> env = null;
String name = null;

public void searchUser(){
    try{
        CreateUserService userService = new CreateUserService();
        Permission permission = userService.getUserPermission(name);
        String panel = permission.getPanelPermission();
        String db = permission.getDbPermission();
        env = permission.getEnvironment();
    }catch(Exception e){

    }
}
%>



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
<div id="text_area_div" class="text_area_div">
<textarea rows="1" cols="10" name="user_name" id="user_name">
</textarea>
<div id="text_submit">
<input type="Submit" value="Submit" onclick="searchUser()">
</div>


<label for="Environment">Environment:</label>
<select name="environment" id="environment">
<%
    if(env!=null)
    {
            for(int i=0;i<env.size();i++)
            {
               out.println("<option value='"+env.get(i)+"'>'"+env.get(i)+"'</option>");
            }
    }
  %>


  </select>
  <label for="PanelPermission">Panel Permission:</label>
  <select name="panel_permission" id="panel" name="panel">
    <option value="read">Select</option>
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
</select>



</div>

</div>
<div id="button_div" class="button_div">
<input type="Submit" value="Submit" onclick="Validate()">
<input type="reset" value="Clear">
</div>

<%
String panelPermission = request.getParameter("panel_parameter");
String environment= request.getParameter("environment");
String operation_type = request.getParameter("operation");
String user_name= request.getParameter("user_name");
try
{
    if(user_name==null ){
        out.println("user name does not exist.");
    }else{


    }
}
catch(Exception e)
{
out.println(e);}

%>

</form>
</body>
</html>
