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


<script>
  function myFunc()
  {
    var userName=document.getElementById("user_name").value;

     var xhttp = new XMLHttpRequest();

     //output
      xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
         var data=this.responseText;
         var x = document.getElementById("env");
         var option = document.createElement("option");
         option.text = data;
         x.add(option);
        x.style.display = 'block';

        }
      };
      xhttp.open("GET", "/getPermission?name="+userName, true);
      xhttp.send();
  }
</script>

<script>
    function nonDisplay(){
           var x = document.getElementById("env");
           x.style.display = 'none';
    }
</script>
<%@include file="header.jsp"%>
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
        System.out.println(panel);
    }catch(Exception e){

    }
}
%>

<form action="/dashboard" method="POST">


<div id="list_div" name="list_div" class="list_div">
<div id="text_area_div" class="text_area_div">
<textarea rows="1" cols="10" name="user_name" id="user_name">
</textarea>
<div id="text_submit">
<input type="button" value="search" onclick="myFunc()">
<input type="reset" value="Clear" onclick ="nonDisplay()" >
</div>

<div>
 <select id='env' style="display: none;">
 </select>
</div>
</form>
</body>
</html>
