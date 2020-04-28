<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书信息添加</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" ></script>
    <style>
        body{
            background-color: rgb(240,242,245);
        }
    </style>

</head>
<body>
<nav  style="position:fixed;z-index: 999;width: 100%;background-color: #fff" class="navbar navbar-default" role="navigation" >
    <div class="container-fluid">
        <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
            <a class="navbar-brand" href="/index">图书管理系统</a>
        </div>
        <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav navbar-left">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        图书管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/book_info">全部图书</a></li>
                        <li class="divider"></li>
                        <li><a href="/book_order">图书订购</a></li>
                        <li class="divider"></li>
                        <li><a href="/arrived_books">图书到货</a></li>
                        <li class="divider"></li>
                        <li><a href="/book_catalog">图书编目</a></li>
                        <li class="divider"></li>
                        <li><a href="/book_reduce">图书减少</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        期刊管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/Journal_Info">全部期刊</a></li>
                        <li class="divider"></li>
                        <li><a href="/Journal_subscribe">期刊征订</a></li>
                        <li class="divider"></li>
                        <li><a href="/Journal_had_catalog">期刊合订编目</a></li>
                        <li class="divider"></li>
                        <li><a href="/Journal_len_return">期刊借阅归还</a></li>
                        <li class="divider"></li>
                        <li><a href="/Journal_reduce">期刊减少</a></li>
                    </ul>
                </li>

                <li >
                    <a href="admin_repasswd.html" >
                        密码修改
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login.html"><span class="glyphicon glyphicon-user"></span>&nbsp;${admin.adminId}，已登录</a></li>
                <li><a href="logout.html"><span class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div style="position: relative;top: 10%;width: 80%;margin-left: 10%">
            <form action="/addJournal_reduce" method="post" id="addbook" >
                <div class="input-group">
                    <span class="input-group-addon">减少日期</span>
                    <input type="text" class="form-control" name="jsrq" id="jsrq" placeholder="请输入减少日期">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">减少原因</span>
                    <input type="text" class="form-control" name="jsyy" id="jsyy" placeholder="请输入减少原因">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">减少结果</span>
                    <input type="text" class="form-control" name="jsjg" id="jsjg" placeholder="请输入减少结果">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">经办人职工号</span>
                    <input type="text" class="form-control" name="jsrzgh" id="jsrzgh" placeholder="请输入经办人职工号">
                </div>
                <input type="submit" value="添加" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#addbook").submit(function () {
                        if($("#jsrq").val()==''||$("#jbrzgh").val()==''||$("#jsjg").val()==''||$("#jsyy").val()==''){
                            alert("请填入完整图书信息！");
                            return mySubmit(false);
                        }
                    })
                </script>
            </form>

</div>



</body>
</html>
