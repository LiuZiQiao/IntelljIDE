<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑《 ${books.tsbh}》</title>
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
            <h3 class="panel-title">编辑《 ${books.tsbh}》</h3>
        </div>
        <div class="panel-body">
            <form action="book_edit_do.html?id=${books.tsbh}" method="post" id="addbook" >

                <div class="input-group">
                    <span class="input-group-addon">图书编号</span>
                    <input type="text"  readonly="readonly" class="form-control" name="tsbh" id="tsbh" value="${books.tsbh}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">图书条形码</span>
                    <input type="text" class="form-control" name="tstxm" id="tstxm" value="${books.tstxm}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">正标题</span>
                    <input type="text" class="form-control" name="zbt" id="zbt"  value="${books.zbt}" >
                </div>

                <div class="input-group">
                    <span  class="input-group-addon">并列标题</span>
                    <input type="text" class="form-control" name="blbt" id="blbt" value="${books.blbt}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">副标题</span>
                    <input type="text" class="form-control" name="fbt" id="fbt"  value="${books.fbt}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">检索关键字</span>
                    <input type="text" class="form-control" name="jsgjz" id="jsgjz"  value="${books.jsgjz}" >
                </div>
                <div class="input-group">
                    <span class="input-group-addon">出版号</span>
                    <input type="text" class="form-control" name="cbh" id="cbh" value="${books.cbh}" >
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">第一作者</span>
                    <input type="text" class="form-control" name="dyzz"  id="dyzz" value="${books.dyzz}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">其他作者</span>
                    <input type="text" class="form-control" name="qtzz" id="qtzz" value="${books.qtzz}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">价格</span>
                    <input type="text" class="form-control" name="jg" id="jg" value="${books.jg}">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">文献类型码</span>
                    <input type="text" class="form-control" name="wxlxm" id="wxlxm" value="${books.wxlxm}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">装订码</span>
                    <input type="text" class="form-control" name="zdm"  id="zdm" value="${books.zdm}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">分类号</span>
                    <input type="text" class="form-control" name="flh"  id="flh" value="${books.flh}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">中国语种码</span>
                    <input type="text" class="form-control" name="zgyzm"  id="zgyzm" value="${books.zgyzm}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">语种码</span>
                    <input type="text" class="form-control" name="yzm"  id="yzm" value="${books.yzm}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">开本</span>
                    <input type="text" class="form-control" name="kb"  id="kb" value="${books.kb}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">页数</span>
                    <input type="text" class="form-control" name="ys"  id="ys" value="${books.ys}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">版次</span>
                    <input type="text" class="form-control" name="bc"  id="bc" value="${books.bc}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">附件名称</span>
                    <input type="text" class="form-control" name="fjmc"  id="fjmc" value="${books.fjmc}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">丛书名称</span>
                    <input type="text" class="form-control" name="csmc"  id="csmc" value="${books.csmc}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">丛书编者</span>
                    <input type="text" class="form-control" name="csbz"  id="csbz" value="${books.csbz}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">出版社</span>
                    <input type="text" class="form-control" name="cbs"  id="cbs" value="${books.cbs}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">出版社级别码</span>
                    <input type="text" class="form-control" name="cbsjbm"  id="cbsjbm" value="${books.cbsjbm}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">出版地</span>
                    <input type="text" class="form-control" name="cbd"  id="cbd" value="${books.cbd}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">出版日期</span>
                    <input type="text" class="form-control" name="cbrq"  id="cbrq" value="${books.cbrq}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">发行单位</span>
                    <input type="text" class="form-control" name="fxdw"  id="fxdw" value="${books.fxdw}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">备注</span>
                    <input type="text" class="form-control" name="bz"  id="bz" value="${books.bz}">
                </div>
                <div class="input-group">
                    <span  class="input-group-addon">图书状态码</span>
                    <input type="text" class="form-control" name="tsztm"  id="tsztm" value="${books.tsztm}">
                </div>
                <input type="submit" value="确定" class="btn btn-success btn-sm" class="text-left">
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
    </div>

</div>

</body>
</html>
