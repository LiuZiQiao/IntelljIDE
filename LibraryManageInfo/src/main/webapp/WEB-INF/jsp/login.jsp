<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/style.css" />
    <style type="text/css">
		fieldset{padding:.35em .625em .75em;margin:0 2px;border:1px solid silver;border-radius:8px}
		legend{padding:.5em;border:0;width:auto;margin-bottom:10px}
		.bg{opacity:0.7}
		#error{color:red;}
	</style>
		
  </head>
  
  <body>
  <center>
  	<span id="error">${login_error}</span>
	<fieldset style="width: 300px;">
	<legend style="">用户登陆</legend>
   		<form action="/login" method="post">
   			用户名称:<input name="username" /><br/>
   			用户口令:<input type="password" name="password" /><br/>
   			<input type="submit" value="登陆"/>&nbsp;&nbsp;&nbsp;&nbsp;
   			<input type="reset" value="重置">
   		</form>
   		还没有账号?请&nbsp;&nbsp;<a href='/regist_page'>注册新用户</a>
   	</fieldset>
  </center>
  
</body>
</html>
