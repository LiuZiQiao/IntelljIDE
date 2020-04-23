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
            <form action="book_add_do.html" method="post" id="addbook" >
                <div class="form-group">
                    <label for="tsbh">图书编号</label>
                    <input type="text" class="form-control" name="tsbh" id="tsbh" placeholder="请输入图书编号">
                </div>
                <div class="form-group">
                    <label for="tstxm">图书条形码</label>
                    <input type="text" class="form-control" name="tstxm" id="tstxm"  placeholder="请输入图书条形码">
                </div>
                <div class="form-group">
                    <label for="zbt">正标题</label>
                    <input type="text" class="form-control"  name="zbt" id="zbt"  placeholder="请输入正标题">
                </div>
                <div class="form-group">
                    <label for="blbt">并列标题</label>
                    <input type="text" class="form-control"  name="blbt" id="blbt"  placeholder="请输入正标题">
                </div>
                <div class="form-group">
                    <label for="fbt">副标题</label>
                    <input type="text" class="form-control" name="fbt" id="fbt"  placeholder="请输入副标题">
                </div>
                <div class="form-group">
                    <label for="jsgjz">检索关键字</label>
                    <input type="text" class="form-control" name="jsgjz" id="jsgjz"  placeholder="请输入检索关键字">
                </div>
                <div class="form-group">
                    <label for="cbh">出版号</label>
                    <input type="text" class="form-control" name="cbh" id="cbh"  placeholder="请输入出版号">
                </div>
                <div class="form-group">
                    <label for="dyzz">第一作者</label>
                    <input type="text" class="form-control" name="dyzz" id="dyzz"  placeholder="请输入第一作者">
                </div>
                <div class="form-group">
                    <label for="qtzz">其他作者</label>
                    <input type="text" class="form-control" name="qtzz" id="qtzz"  placeholder="请输入其他作者">
                </div>
                <div class="form-group">
                    <label for="jg">价格</label>
                    <input type="text" class="form-control"  name="jg"  id="jg" placeholder="请输入价格">
                </div>
                <div class="form-group">
                    <label for="wxlxm">文献类型码</label>
                    <input type="text" class="form-control" name="wxlxm" id="wxlxm"  placeholder="请输入文献类型码">
                </div>
                <div class="form-group">
                    <label for="zdm">装订码</label>
                    <input type="text" class="form-control"  name="zdm" id="zdm"   placeholder="请输入装订码">
                </div>
                <div class="form-group">
                    <label for="flh">分类号</label>
                    <input type="text" class="form-control" name="flh" id="flh"  placeholder="请输入分类号">
                </div>
                <div class="form-group">
                    <label for="zgyzm">中国语种码</label>
                    <input type="text" class="form-control"  name="zgyzm" id="zgyzm" placeholder="请输入中国语种码">
                </div>
                <div class="form-group">
                    <label for="yzm">语种码</label>
                    <input type="text" class="form-control"  name="yzm"  id="yzm"   placeholder="请输入语种码">
                </div>
                <div class="form-group">
                    <label for="kb">开本</label>
                    <input type="text" class="form-control"  name="kb"  id="kb"   placeholder="请输入开本">
                </div>
                <div class="form-group">
                    <label for="ys">页数</label>
                    <input type="text" class="form-control"  name="ys"  id="ys"   placeholder="请输入页数">
                </div>
                <div class="form-group">
                    <label for="bc">版次</label>
                    <input type="text" class="form-control"  name="bc"  id="bc"   placeholder="请输入版次">
                </div>
                <div class="form-group">
                    <label for="fjmc">附件名称</label>
                    <input type="text" class="form-control"  name="fjmc"  id="fjmc"   placeholder="请输入附件名称">
                </div>
                <div class="form-group">
                    <label for="csmc">丛书名称</label>
                    <input type="text" class="form-control"  name="csmc"  id="csmc"   placeholder="请输入丛书名称">
                </div>
                <div class="form-group">
                    <label for="csbz">丛书编者</label>
                    <input type="text" class="form-control"  name="csbz"  id="csbz"   placeholder="请输入丛书编者">
                </div>
                <div class="form-group">
                    <label for="cbs">出版社</label>
                    <input type="text" class="form-control"  name="cbs"  id="cbs"   placeholder="请输入出版社">
                </div>
                <div class="form-group">
                    <label for="cbsjbm">出版社级别码</label>
                    <input type="text" class="form-control"  name="cbsjbm"  id="cbsjbm"   placeholder="请输入出版社级别码">
                </div>
                <div class="form-group">
                    <label for="cbd">出版地</label>
                    <input type="text" class="form-control"  name="cbd"  id="cbd"   placeholder="请输入出版地">
                </div>
                <div class="form-group">
                    <label for="cbrq">出版日期</label>
                    <input type="text" class="form-control"  name="cbrq"  id="cbrq"   placeholder="请输入出版日期">
                </div>
                <div class="form-group">
                    <label for="fxdw">发行单位</label>
                    <input type="text" class="form-control"  name="fxdw"  id="fxdw"   placeholder="请输入发行单位">
                </div>
                <div class="form-group">
                    <label for="bz">备注</label>
                    <input type="text" class="form-control"  name="bz"  id="bz"   placeholder="请输入备注">
                </div>
                <div class="form-group">
                    <label for="tsztm">图书状态码</label>
                    <input type="text" class="form-control"  name="tsztm"  id="tsztm"   placeholder="请输入图书状态">
                </div>
                <input type="submit" value="添加" class="btn btn-success btn-sm" class="text-left">
                <script>
                    function mySubmit(flag){
                        return flag;
                    }
                    $("#addbook").submit(function () {
                        if($("#tsbh").val()==''||$("#tstxm").val()==''||$("#zbt").val()==''||$("#blbt").val()==''||$("#blbt").val()==''||$("#jsgjz").val()==''||$("#cbh").val()==''||$("#dyzz").val()==''||$("#qtzz").val()==''||$("#jg").val()==''||$("#wxlxm").val()==''
                    ||$("#zdm").val()==''||$("#flh").val()==''||$("#zgyzm").val()==''||$("#yzm").val()==''||$("#kb").val()==''||$("#ys").val()==''||$("#bc").val()==''||$("#fjmc").val()==''||$("#csmc").val()==''||$("#csbz").val()==''||$("#cbs").val()==''
                            ||$("#cbsjbm").val()==''||$("#cbd").val()==''||$("#cbrq").val()==''||$("#fxdw").val()==''||$("#bz").val()==''||$("#tsztm").val()==''){
                            alert("请填入完整图书信息！");
                            return mySubmit(false);
                        }
                    })
                </script>
            </form>

</div>



</body>
</html>
