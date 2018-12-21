<%@ page import="com.paytm.qapanel.model.*" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" href="css/basic.css">
<script src="js/validation.js" type="text/javascript"></script>

</head>
<body>

<form action="dashbord" method="POST">
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
  <option value="paytmpgdb">PAYTMPGDB</option>
  <option value="pgpdb">PGPDB</option>
  <option value="pgplusbo">pgplusbo</option>
</select>
<label for="Environment">Environment:</label>
<select name="environment" id="environment">
  <option value="select">Select</option>
  <option value="staging">STAGING</option>
  <option value="ite">ITE</option>
  <option value="hotfix">HOTFIX</option>
  <option value="qa5">QA5</option>
  <option value="qa6">QA6</option>
  <option value="qa7">QA7</option>
  <option value="pos">POS</option>
  <option value="automation">AUTOMATION</option>
  </select>
  <label for="Operation">Operation:</label>
  <select name="operation" id="operation">
  <option value="select">SELECT</option>
  <option value="update">UPDATE</option>
  <option value="insert">INSERT</option>
  <option value="alter">ALTER</option>
  <option value="delete">DELETE</option>
  <option value="create">CREATE</option>
  <option value="drop">DROP</option>
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
String sql_query= request.getParameter("query_text");
out.println(operation_type);
out.println(sql_query);
%>

</form>
</body>
</html>
