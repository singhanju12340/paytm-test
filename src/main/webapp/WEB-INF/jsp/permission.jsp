<%@ page import="com.paytm.qapanel.model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.paytm.qapanel.service.*"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" href="css/basic.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="js/validation.js" type="text/javascript"></script>
</head>
<body>
<script>
  function myFunc() {


      $.get("/getPermission?name=viku",function(data,status){
            console.log("res => ",result);
      });
      return false;
  }
</script>
<%@include file="header.jsp"%>


<%-- 
<form action="/dashboard" method="POST" onsubmit="return myFunc()">
--%>
<div id="list_div" name="list_div" class="list_div">

<div id="text_area_div" class="text_area_div">
<textarea rows="8" cols="100" name="query_text" id="query_text">
</textarea>
</div>

<div id="button_div" class="button_div">
<input type="submit" value="Submit" onsubmit="myFunc()" >
<input type="reset" value="Clear">
</div>

</div>
<%--
<%
         PermissionImpl permissionImpl = new PermissionImpl();
         Permission permission = permissionImpl.getPermmisionImpl("viku");
         String panel = permission.getPanelPermission();
%>
--%>


<div id="list_div" name="list_div" class="list_div">
 <table border=1>
       <tr>
               <td width=70px>Environment permission</td>
               <td width=150px>Panel permission</td>
               <td width=150px>Database permission</td>
       </tr>
       <tr>
               <td width=70px></td>
               <td width=150px></td>
               <td width=150px></td>
        </tr>
 </table>
</div>

<%--</form> --%>
</body>
</html>
