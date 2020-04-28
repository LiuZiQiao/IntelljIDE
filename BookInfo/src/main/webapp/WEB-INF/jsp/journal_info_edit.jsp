<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑《 ${journalInfos.qkbh}》</title>
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
            <h3 class="panel-title">编辑《 ${journalInfos.qkbh}》</h3>
        </div>
        <div class="panel-body">
            <form action="/doupdateJouranl_info?id=${journalInfos.qkbh}" method="post" id="addbook" >

                <div class="input-group">
                    <span class="input-group-addon">期刊编号</span>
                    <input type="text"  readonly="readonly" class="form-control" name="qkbh" id="qkbh" value="${journalInfos.qkbh}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">期刊条形码</span>
                    <input type="text" class="form-control" name="qktxm" id="qktxm" value="${journalInfos.qktxm}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">期刊中文名称</span>
                    <input type="text" class="form-control" name="qkzwmc" id="qkzwmc"  value="${journalInfos.qkzwmc}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">期刊英文名称</span>
                    <input type="text" class="form-control" name="qkywmc" id="qkywmc"  value="${journalInfos.qkywmc}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">出版号</span>
                    <input type="text" class="form-control" name="cbh" id="cbh"  value="${journalInfos.cbh}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">编辑部</span>
                    <input type="text" class="form-control" name="bjb" id="bjb"  value="${journalInfos.bjb}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">总编</span>
                    <input type="text" class="form-control" name="zb" id="zb"  value="${journalInfos.zb}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">单价</span>
                    <input type="text" class="form-control" name="dj" id="dj"  value="${journalInfos.dj}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">创刊年月</span>
                    <input type="text" class="form-control" name="ckny" id="ckny"  value="${journalInfos.ckny}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">期号</span>
                    <input type="text" class="form-control" name="qh" id="qh"  value="${journalInfos.qh}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">总期号</span>
                    <input type="text" class="form-control" name="zqh" id="zqh"  value="${journalInfos.zqh}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">分类号</span>
                    <input type="text" class="form-control" name="flh" id="flh"  value="${journalInfos.flh}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">中国语种码</span>
                    <input type="text" class="form-control" name="zgyzm" id="zgyzm"  value="${journalInfos.zgyzm}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">语种码</span>
                    <input type="text" class="form-control" name="yzm" id="yzm"  value="${journalInfos.yzm}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">期刊类别码</span>
                    <input type="text" class="form-control" name="qklbm" id="qklbm"  value="${journalInfos.qklbm}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">期刊状态码</span>
                    <input type="text" class="form-control" name="qkztm" id="qkztm" value="${journalInfos.qkztm}">
                </div>
                <input type="submit" value="确定" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#addbook").submit(function () {
                        if($("#qkbh").val()==''||$("#qktxm").val()==''||$("#qkzwmc").val()==''||$("#qkywmc").val()==''||$("#cbh").val()==''||$("#bjb").val()==''||$("#zb").val()==''||
                            $("#dj").val()==''||$("#ckny").val()==''||$("#qh").val()==''||$("#zqh").val()==''||
                            $("#flh").val()==''||$("#zgyzm").val()==''||$("#yzm").val()==''||$("#qklbm").val()==''||$("#qkztm").val()==''){
                            alert("请填入完整图书信息！");
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
