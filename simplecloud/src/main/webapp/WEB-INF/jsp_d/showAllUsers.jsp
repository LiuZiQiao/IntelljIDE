<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showAllUsers.jsp' starting page</title>
     
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		a{text-decoration: none}
		table{width: 100%} 
		table,tr,th{border: 1px solid gray;border-collapse:collapse;}
		div{border: 0px solid red;}
	</style>
   <script src="js/jquery-1.8.3.js" type="text/javascript"></script>
    <!-- <script src="js/outer.js" type="text/javascript"></script> -->
	<script type="text/javascript">
		$(function(){
			//表格隔行变色
			$("table>tbody>tr:even").css("background","gray");
			$("table>tbody>tr:odd").css("background","pink");
		});
	</script>
  </head>
  
  <body>
  	${user.nickname}&nbsp;&nbsp;先生/女士，欢迎您,<a style="margin-left: 1050px" href="admin/logout">【退出】</a></span><br/><br/><br/>
	 <hr style="width: 100%" />
	<table>
		<thead>
    		<tr>
    			<th>用户编号</th>
    			<th>用户姓名</th>
    			<th>用户口令</th>
    			<th>用户性别</th>
    			<th>用户昵称</th>
    			<th>操作</th>
    			<th>当前状态</th>
    			<th>更改状态</th>
    		</tr>
    	</thead>
    		<tbody>
    	<c:forEach var="user" items="${userList}">
    		<tr>
    			<th>${user.userid}</th>
    			<th>${user.username}</th>
    			<th>${user.password}</th>
    			<th>${user.sex}</th>
    			<th>${user.nickname}</th>
    			<th>
    			
    			<button onclick="modifyUser_passByUserid(${user.userid})">修改密码</button>
    			<script>
    				function modifyUser_passByUserid(userid){
    					var newPass=prompt("请输入新密码","请认真填写");
    					location.href="user/modifyUser_passByUserid?userid="+userid+"&newPass="+newPass+"&pageNum=${pageInfo.pageNum}&maxPage=${pageInfo.pages}";
    				}
    			</script>
    			</th>
    			<th>${user.state}</th>
    			<th> 
    				<button title="点击后修改用户状态" onclick="javaScript:location.href='admin/changeState?userid=${user.userid}&state=${user.state}&pageNum=${pageInfo.pageNum}&maxPage=${pageInfo.pages}'">${user.state eq '启用'?'禁用':'启用'}</button>
    			</th>
    		</tr>
    		</c:forEach>
    		</tbody>
    	</table>
	<center>
 		当前第${pageInfo.pageNum}页/总共${pageInfo.pages}页  ，
 		<a href="admin/getAllUsers?pageNum=${pageInfo.pageNum-1}&maxPage=${pageInfo.pages}">上一页</a> 
 		<a href="admin/getAllUsers?pageNum=${pageInfo.pageNum+1}&maxPage=${pageInfo.pages}">下一页</a> 
 	</center>
 	</body>
</html>
