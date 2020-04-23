<%--
  Created by IntelliJ IDEA.
  User: gxy19
  Date: 2020/4/19
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
    <meta name="author" content="Coderthemes">

    <link rel="shortcut icon" href="assets/images/favicon_1.ico">

    <title>软通网盘</title>

    <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="assets/css/core.css" rel="stylesheet" type="text/css">
    <link href="assets/css/icons.css" rel="stylesheet" type="text/css">
    <link href="assets/css/components.css" rel="stylesheet" type="text/css">
    <link href="assets/css/pages.css" rel="stylesheet" type="text/css">
    <link href="assets/css/menu.css" rel="stylesheet" type="text/css">
    <link href="assets/css/responsive.css" rel="stylesheet" type="text/css">

    <script src="assets/js/modernizr.min.js"></script>

</head>
<div class="wrapper-page">
    <div class="panel panel-color panel-primary panel-pages">
        <div class="panel-heading bg-img">
            <div class="bg-overlay"></div>
            <h3 class="text-center m-t-10 text-white"> 重置密码 </h3>
        </div>


        <div class="panel-body"><span id="regist_error" style="color:red;">${regist_error}</span>
            <form class="form-horizontal m-t-20" action="user/recoverpw">
                <div class="form-group">
                    <div class="col-xs-12">
                        <input name="username" class="form-control input-lg" type="text" required="" placeholder="账户名">
                    </div>
                </div>

                <div class="form-group text-center m-t-40">
                    <div class="col-xs-12">
                        <button id="submit" class="btn btn-primary waves-effect waves-light btn-lg w-lg" type="submit">发送验证邮件</button>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>


<script>
    var resizefunc = [];
</script>

<!-- Main  -->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/detect.js"></script>
<script src="assets/js/fastclick.js"></script>
<script src="assets/js/jquery.slimscroll.js"></script>
<script src="assets/js/jquery.blockUI.js"></script>
<script src="assets/js/waves.js"></script>
<script src="assets/js/wow.min.js"></script>
<script src="assets/js/jquery.nicescroll.js"></script>
<script src="assets/js/jquery.scrollTo.min.js"></script>
<script src="assets/js/jquery.app.js"></script>
<script>
    $("#agreement").click(function(){
        if($("#checkbox-signup").prop("checked")){
            $("#submit").prop("disabled",false);
        }else{
            $("#submit").prop("disabled",true);
        }
    });

    if($("#regist_error").html()==""){
        $("#regist_error").hide(0);
    }else{
        $("#regist_error").show(0).delay(2000).fadeOut(2000);
    }

</script>
</body>
</html>
