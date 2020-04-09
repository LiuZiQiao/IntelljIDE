<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'upload.jsp' starting page</title>

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
<!-- 单个文件上传 -->
<form action="file/upload" enctype="multipart/form-data" method="post">
    <input type="file" name="file"><br/><br/>
    <input type="submit" value="单个上传">
</form>
<hr/>
<img src="upload/${fileName}" width="100px" height="100px"/>
<br/><a href="file/download?fileName=Koala.jpg">下载</a>

<hr/>


</body>
</html>
