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
    
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
    <meta name="author" content="Coderthemes">

    <link rel="shortcut icon" href="assets/images/cloud.ico">

    <title>简·存取后台管理系统</title>

    <link href="assets/plugins/sweetalert/dist/sweetalert.css" rel="stylesheet" type="text/css">

    <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="assets/css/core.css" rel="stylesheet" type="text/css">
    <link href="assets/css/icons.css" rel="stylesheet" type="text/css">
    <link href="assets/css/components.css" rel="stylesheet" type="text/css">
    <link href="assets/css/pages.css" rel="stylesheet" type="text/css">
    <link href="assets/css/menu.css" rel="stylesheet" type="text/css">
    <link href="assets/css/responsive.css" rel="stylesheet" type="text/css">

    <script src="assets/js/modernizr.min.js"></script>
</head>


<body class="fixed-left">

<!-- Begin page -->
<div id="wrapper">

    <!-- Top Bar Start -->
    <div class="topbar">
        <!-- LOGO -->
        <div class="topbar-left">
            <div class="text-center" title="third">
                <a href="admin.html" class="logo"><i class="md md-cloud-queue"></i> <span>简·存取后台</span></a>
            </div>
        </div>
        <div class="navbar navbar-default" role="navigation">
            <div class="container">
                <div class="">
                    <div class="pull-left">
                        <button class="button-menu-mobile open-left">
                            <i class="fa fa-bars"></i>
                        </button>
                        <span class="clearfix"></span>
                    </div>

                    <ul class="nav navbar-nav navbar-right pull-right">
                        <li class="hidden-xs">
                            <a href="admin/logout">
                                <i class="fa fa-sign-out" aria-hidden="true"></i>
                                	退出</a>
                        </li>
                    </ul>
                </div>
                <!--/.nav-collapse -->
            </div>
        </div>
    </div>
</div>
<!-- Top Bar End -->


<!-- ========== Left Sidebar Start ========== -->

<div class="left side-menu">
    <div class="sidebar-inner slimscrollleft">
        <div class="user-details">
            <div class="pull-left">
                <img src="assets/images/users/avatar-1.jpg" alt="" class="thumb-md img-circle">
            </div>
            <div class="user-info">
                <p class="text-muted m-0" id="userName">管理员</p>
                <p>${user.nickname}&nbsp;&nbsp;,欢迎您</p>
            </div>
        </div>
        <!--- Divider -->
        <div id="sidebar-menu">
            <ul>
                <li>
                    <a href="javascript:return false;" class="waves-effect waves-light"><i class="md md-share"></i><span>用户列表</span></a>
                </li>

            </ul>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!-- Left Sidebar End -->


<!-- ============================================================== -->
<!-- Start right Content here -->
<!-- ============================================================== -->
<div class="content-page">
    <!-- Start content -->
    <div class="content">
        <div class="container">
                <div class="panel">
                    <div class="panel-body">
                        <table class="table table-bordered table-striped" id="datatable-editable">
                            <thead>
                            <tr>
                                <th>账号名称</th>
    							<th>用户昵称</th>
    							<th>当前状态</th>
    							<th>更改状态</th>
                            </tr>
                            </thead>
                            <tbody>
								<c:forEach var="user" items="${userList}">
    								<tr>
    									<th>${user.username}</th>
    									<th>${user.nickname}</th>
    									<th>${user.state}</th>
    									<th>
    										<button type="button" class="btn btn-primary waves-effect waves-light" title="点击后修改用户状态" onclick="javaScript:location.href='admin/changeState?userid=${user.userid}&state=${user.state}&pageNum=${pageInfo.pageNum}&maxPage=${pageInfo.pages}'">${user.state eq '启用'?'禁用':'启用'}</button>
    									</th>
    								</tr>
    							</c:forEach>
                            </tbody>
                        </table>
                        <!-- 分页 -->
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="dataTables_info" id="datatable-editable_info" role="status"
                                     aria-live="polite"> 
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="dataTables_paginate paging_simple_numbers" id="datatable-editable_paginate">
                                    <ul class="pagination">
                                        <li class="paginate_button previous" aria-controls="datatable-editable"
                                            tabindex="0" id="datatable-editable_previous">
                                            <a href="admin/getAllUsers?pageNum=${pageInfo.pageNum-1}&maxPage=${pageInfo.pages}">上一页</a>
                                        </li>
                                        <li class="paginate_button active" aria-controls="datatable-editable"
                                            tabindex="0"><a href="javascript:return false;">当前第${pageInfo.pageNum}页/总共${pageInfo.pages}页 </a>
                                        </li>
                                     
                                        <li class="paginate_button next" aria-controls="datatable-editable"
                                            tabindex="0" id="datatable-editable_next">
                                            <a href="admin/getAllUsers?pageNum=${pageInfo.pageNum+1}&maxPage=${pageInfo.pages}">下一页</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <!-- end: page -->
            </div> <!-- end Panel -->
        </div>
    </div>
</div>
<!-- END wrapper -->

<!-- jQuery  -->
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

<!-- moment js  -->
<script src="assets/plugins/moment/moment.js"></script>

<!-- counters  -->
<script src="assets/plugins/waypoints/lib/jquery.waypoints.js"></script>
<script src="assets/plugins/counterup/jquery.counterup.min.js"></script>

<!-- sweet alert  -->
<script src="assets/plugins/sweetalert/dist/sweetalert.min.js"></script>


<!-- flot Chart -->
<script src="assets/plugins/flot-chart/jquery.flot.js"></script>
<script src="assets/plugins/flot-chart/jquery.flot.time.js"></script>
<script src="assets/plugins/flot-chart/jquery.flot.tooltip.min.js"></script>
<script src="assets/plugins/flot-chart/jquery.flot.resize.js"></script>
<script src="assets/plugins/flot-chart/jquery.flot.pie.js"></script>
<script src="assets/plugins/flot-chart/jquery.flot.selection.js"></script>
<script src="assets/plugins/flot-chart/jquery.flot.stack.js"></script>
<script src="assets/plugins/flot-chart/jquery.flot.crosshair.js"></script>

<!-- todos app  -->
<script src="assets/pages/jquery.todo.js"></script>
<!-- chat app  -->
<script src="assets/pages/jquery.chat.js"></script>
<!-- dashboard  -->
<script src="assets/pages/jquery.dashboard.js"></script>
<script src="js/main.js"></script>
</body>
</html>