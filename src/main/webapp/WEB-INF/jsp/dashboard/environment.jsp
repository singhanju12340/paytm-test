<%@ page import="com.paytm.qapanel.*" %>
<%@ page import="pageNumber.*, java.util.*, java.io.*" %>
<%@ page import ="java.sql.*"%>
<%@ page import ="java.util.Map.Entry, java.util.Properties, java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/basic.css">
<script src="js/validation.js" type="text/javascript"></script>
<script src="js/functions.js" type="text/javascript"></script>
<script>
    function checktext(aa)
    {
    for(i=1;i<aa;i++)
    {
    var env = document.getElementById(i+"_envtext").value;
    var ip=document.getElementById(i+"_text").value;
    alert(env+ip);
    }
    }
</script>
</head>
<body>
<form action="dashboard" method="POST" name="envform" id="envform">
<%
int rowId=1;
int i=1,j=1;
HashMap<String, String> value_from_file=new HashMap<>();
String envname=request.getParameter("database");
%>
<div id="page_div" name="page_div" class="page_div">
<div id="main_header_div" name="main_header_div" class="main_header_div">
<div id="dashbord_div" name="dashbord_div" class="dashbord_div">
<a href="">Dashbord</a>
</div>
<div id="user_div" name="user_div" class="user_div">
<a href="">USERS</a>
</div>
<div id="permission_div" name="permission_div" class="permission_div">
<a href="">
Permission
</a></div>
<div id="environment_div" name="environment_div" class="environment_div">
<a href="">Environment</a></div>
<div id="environment_div" name="environment_div" class="environment_div">Example</div>
</div>
<div id="center_div" name="center_div" class="center_div">
<table border=1 align="center" padding= "10px" float="right" top="100px" id="myTable"><tr>
<td width=180px>Environment Name</td>
<td width=180px>Server IP</td>
<td width=80px>EDIT</td>
<td width=80px>SAVE</td>

</tr>
<%
UpdateProperty up=new UpdateProperty();

Properties p = up.getProperty();
Set<Entry<Object, Object>>  entrySet1 = p.entrySet();
try{

for (final Map.Entry<Object, Object> entry : p.entrySet()) {
          if(entry.getKey().toString().trim().startsWith("IP"))
          {
          //value_from_file.put((String) entry.getKey(), (String) entry.getValue());
          String envKey=entry.getKey().toString().substring(3);
%>
<tr id= <%= rowId%>>
<td><input type="text" value= <%= envKey %>  id= <%= i+"_envtext"%> disabled="disabled" name=<%= i+"_envtext"%> required='required'></td>
<td><input type="text" value= <%= entry.getValue().toString() %>  id= <%= i+"_text"%> disabled="disabled" name=<%= i+"_text"%> required='required'> </td>
<td><input type="Button" value="EDIT" id= <%= i+"_edit"%> onClick="enableText(<%= i%>);" ></td>
<td><input type="Submit" value="SAVE" id= <%= i+"_save"%>></td>
<%
j=i;
if(request.getParameterValues(i+"_text")!=null)
{
//out.println(request.getParameterValues(i+"_text"));
String e=request.getParameter(i+"_envtext");
String ip=request.getParameter(i+"_text");
up.updateIP(p,request.getParameter(i+"_envtext"),request.getParameter(i+"_text"));
//out.println("/n"+i);
//p.load(reader);
}
if(request.getParameter(i+"_text")==null)
{

}
++i;
//out.println("Text value of i is:  "+i);
rowId=i;
}}
if(i>entrySet1.size())
{
String en=request.getParameter((entrySet1.size()+1)+"_envtext");
String enip=request.getParameter((entrySet1.size()+1)+"_text");
//out.println("Value of entry: "+entrySet1.size());
//out.println("value of en: "+en+ " Value of enip: "+enip);
if(request.getParameter((entrySet1.size()+1)+"_envtext")!=null)
{
up.updateIP(p,request.getParameter((entrySet1.size()+1)+"_envtext"),request.getParameter((entrySet1.size()+1)+"_text"));
//out.println("value updated: ");

}}

}
catch(Exception e)
{
out.println(e);
}
%>

<div class="button_div" id="button_div">
<input type="button" value="Add New Environment" onClick="addEnv(<%= rowId%>)">
</div>
<script type="text/javascript">

</script>
</table>
</div>
<input type="button" value="SUBMIT" onClick="checktext(<%= rowId%>)">
</div>
</div>
</form>
</body>

</html>