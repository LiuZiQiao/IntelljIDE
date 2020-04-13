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

	<title>My JSP 'showAllBooks.jsp' starting page</title>

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
	<script type="text/javascript">
		$(function(){
			//表格隔行变色
			$("table>tbody>tr:even").css("background","gray");
			$("table>tbody>tr:odd").css("background","pink");
		});
	</script>
</head>
<!-- ajax:无需重新加载整个网页的情况下，能够更新部分网页的技术 (局部刷新)-->
<body>
<form enctype="multipart/form-data" id="uploadForm">
	<img id="personal_photo" src="upload/default.jpg" onclick="sc()" width="50px" height="50px"/>
	<input type="file" name="file" id="file" style="display: none"/>
</form>
${user.username}先生/女士，欢迎您,
<a style="margin-left: 1050px" href="user/logout">【退出】</a></span><br/><br/><br/>
<hr style="width: 100%" />
<table>
	<thead>
	<tr>
		<th>订购号</th>
		<th>实到价格</th>
		<th>实到册数</th>
		<th>到货日期</th>
		<th>经手人职工号</th>
		<th>备注</th>
	</tr>
	</thead>
	<tbody>
	<!-- 美元符大括号-EL表达式 -从page,request,session,application -->
	<!-- 	c:forEach var="集合中每一个对象的别名" items="要遍历的集合" sessionScope.userList -->
	<c:forEach var="book" items="${bookList}">
		<tr>
			<!-- ${book.DGH}=== -->
				<%-- <%user.getUserid()%> --%>
			<th>${book.SDJG}</th>
			<th>${book.SDCS}</th>
			<th>${book.DHRQ}</th>
			<th>${book.JSRZGH}</th>
			<th>${book.BZ}</th>
		</tr>
	</c:forEach>
	</tbody>
	<center>
		当前第${pageInfo.pageNum}页/总共${pageInfo.pages}页  ，
		<a href="user/getAllUsers?pageNum=${pageInfo.pageNum-1}&maxPage=${pageInfo.pages}">上一页</a>
		<a href="user/getAllUsers?pageNum=${pageInfo.pageNum+1}&maxPage=${pageInfo.pages}">下一页</a>
	</center>
</table>
</body>
</html>
