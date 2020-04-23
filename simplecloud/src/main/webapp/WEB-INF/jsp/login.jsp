<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
    <meta name="author" content="Coderthemes">

    <link rel="shortcut icon" href="assets/images/favicon_1.ico" >

    <title>简·存取</title>

    <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/core.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/icons.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/components.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/pages.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/menu.css" rel="stylesheet" type="text/css"/>
    <link href="assets/css/responsive.css" rel="stylesheet" type="text/css"/>

    <script src="assets/js/modernizr.min.js"></script>
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->


</head>
<body>


<div class="wrapper-page">
    <div class="panel panel-color panel-primary panel-pages">
        <div class="panel-heading bg-img">
            <div class="bg-overlay"></div>
            <h3 class="text-center m-t-10 text-white">账户登录</h3>
        </div>


        <div class="panel-body">
            <form action="user/login" class="form-horizontal m-t-20" id="login-form" method="post" onsubmit="return check();">
			<span style="color:red;">${login_error}</span>	
				<span id="info" style="display:none;position:absolute;z-index: 1;font-size: 15px;margin-top: 10px;opacity: 0.6;">&nbsp;&nbsp;&nbsp;用户名或密码均不能为空</span>
                <div class="form-group">
                    <div class="col-xs-12">
                        <input class="form-control input-lg" id="username" name="username" type="text" required=""
                               placeholder="用户名">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-12">
                        <input class="form-control input-lg" id="password" name="password" type="password" required=""
                               placeholder="密码">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-12">
                        <div class="checkbox checkbox-primary">
                            <input id="checkbox-signup" type="checkbox">
                            <label for="checkbox-signup">
                                	记住密码
                            </label>
                        </div>

                    </div>
                </div>

                <div class="form-group text-center m-t-40">
                    <div class="col-xs-12">
                        <button class="btn btn-primary btn-lg w-lg waves-effect waves-light" type="submit">
                        	登录
                        </button>
                    </div>
                </div>

                <div class="form-group m-t-30">
                    <div class="col-sm-7">
                        <a href="recoverpw.html"><i class="fa fa-lock m-r-5"></i> 忘记密码？</a>
                    </div>
                    <div class="col-sm-5 text-right">
                        <a href="user/regist_page">前往注册</a>
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
<script type="text/javascript">
	function check(){
		$(obj).attr("disabled", true);
        var username = $.trim($('#username').val());
        var password = $.trim($('#password').val());
        if (username == "" || password == "") {
            $("#info").show(0).delay(2000).fadeOut(2000);
            $(obj).attr("disabled", false);
            return false;
        } else {
        	return true;
        }
	}
</script>

</body>
</html>