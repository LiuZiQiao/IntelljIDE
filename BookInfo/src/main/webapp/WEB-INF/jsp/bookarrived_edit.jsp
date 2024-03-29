<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑《 ${books.dgh}》</title>
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

<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 10%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">编辑《 ${books.dgh}》</h3>
        </div>
        <div class="panel-body">
            <form action="dodoupdatebook_arrived?id=${books.dgh}" method="post" id="addbook" >

                <div class="input-group">
                    <span class="input-group-addon">订购号</span>
                    <input type="text"  readonly="readonly" class="form-control" name="dgh" id="dgh" value="${books.dgh}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">实到价格</span>
                    <input type="text" class="form-control" name="sdjg" id="sdjg" value="${books.sdjg}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">实到册数</span>
                    <input type="text" class="form-control" name="sdcs" id="sdcs"  value="${books.sdcs}" >
                </div>

                <div class="input-group">
                    <span  class="input-group-addon">到货日期</span>
                    <input type="text" class="form-control" name="dhrq" id="dhrq" value="${books.dhrq}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">经手人职工号</span>
                    <input type="text" class="form-control" name="jsrzgh" id="jsrzgh"  value="${books.jsrzgh}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">备注</span>
                    <input type="text" class="form-control" name="bz" id="bz" value="${books.bz}" >
                </div>
                <input type="submit" value="确定" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#addbook").submit(function () {
                        if($("#dgh").val()==''||$("#sdcs").val()==''||$("#sdjg").val()==''
                            ||$("#dhrq").val()==''||$("#jsgjz").val()==''||$("#bz").val()==''){
                            alert("请填入完整订购图书信息！");
                            return mySubmit(false);
                        }
                    })
                </script>
            </form>
        </div>
    </div>

</div>

</body>
</html>
