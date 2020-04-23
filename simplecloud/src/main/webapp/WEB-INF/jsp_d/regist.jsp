<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <center>
   <fieldset style="width: 300px;">
		<legend style="">用户注册</legend>
   		<form action="user/regist" method="post">
   			用户名称:<input name="username"><br/>
   			用户口令:<input type="password" name="password"><br/>
   			联系电话:<input type="tel" name="tel"><br/>
   			用户昵称:<input name="nickname"><br/>	  
   				  <br/><br/> 
   			<input type="submit" value="注册">&nbsp;&nbsp;&nbsp;&nbsp;
   			<input type="reset" value="重置">
   		</form>
   	</fieldset>
   	</center>
  </body>
</html>
