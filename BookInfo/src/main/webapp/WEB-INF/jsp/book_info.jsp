<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.lxk.book.entitys.Book_Info" %>
<html>
<head>
    <title>全部图书</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js" ></script>
    <style>
        body{
            background-color: rgb(240,242,245);
        }
    </style>

</head>
<body >
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


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    温馨提示
                </h4>
            </div>
            <div class="modal-body">
                使用结束后请安全退出。
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">知道了
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<c:if test="${!empty login}">
    <script>
        $(function () {
            $("#myModal").modal({
                show: true
            })
        })
    </script>
</c:if>

<%--<div class="panel panel-default" style="width: 90%;margin-left: 5%">--%>
<div class="panel panel-default" style="position: relative;top: 80px ;width: 90%;margin-left: 5%">
    <div class="panel-heading">
        <h3 class="panel-title">
                全部图书
        </h3>

    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th></th>
                <th>图书编号</th>
                <th>图书条形码</th>
                <th>正标题</th>
                <th>并列标题</th>
                <th>副标题</th>
                <th>检索关键字</th>
                <th>出版号</th>
                <th>第一作者</th>
                <th>其他作者</th>
                <th>价格</th>
                <th>文献类型码</th>
                <th>装订码</th>
                <th>分类号</th>
                <th>中国语种码</th>
                <th>语种码</th>
                <th>开本</th>
                <th>页数</th>
                <th>版次</th>
                <th>附件名称</th>
                <th>丛书名称</th>
                <th>丛书编者</th>
                <th>出版社</th>
                <th>出版社级别码</th>
                <th>出版地</th>
                <th>出版日期</th>
                <th>发行单位</th>
                <th>备注</th>
                <th>图书状态码</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${books_info}" var="alog">
                <td>
                    <td><c:out value="${alog.tsbh}"></c:out></td>
                    <td><c:out value="${alog.tstxm}"></c:out></td>
                    <td><c:out value="${alog.zbt}"></c:out></td>
                    <td><c:out value="${alog.blbt}"></c:out></td>
                    <td><c:out value="${alog.fbt}"></c:out></td>
                    <td><c:out value="${alog.jsgjz}"></c:out></td>
                    <td><c:out value="${alog.cbh}"></c:out></td>
                    <td><c:out value="${alog.dyzz}"></c:out></td>
                    <td><c:out value="${alog.qtzz}"></c:out></td>
                    <td><c:out value="${alog.jg}"></c:out></td>
                    <td><c:out value="${alog.wxlxm}"></c:out></td>
                    <td><c:out value="${alog.zdm}"></c:out></td>
                    <td><c:out value="${alog.flh}"></c:out></td>
                    <td><c:out value="${alog.zgyzm}"></c:out></td>
                    <td><c:out value="${alog.yzm}"></c:out></td>
                    <td><c:out value="${alog.kb}"></c:out></td>
                    <td><c:out value="${alog.ys}"></c:out></td>
                    <td><c:out value="${alog.bc}"></c:out></td>
                    <td><c:out value="${alog.fjmc}"></c:out></td>
                    <td><c:out value="${alog.csmc}"></c:out></td>
                    <td><c:out value="${alog.csbz}"></c:out></td>
                    <td><c:out value="${alog.cbs}"></c:out></td>
                    <td><c:out value="${alog.cbsjbm}"></c:out></td>
                    <td><c:out value="${alog.cbd}"></c:out></td>
                    <td><c:out value="${alog.cbrq}"></c:out></td>
                    <td><c:out value="${alog.fxdw}"></c:out></td>
                    <td><c:out value="${alog.bz}"></c:out></td>
                    <td><c:out value="${alog.tsztm}"></c:out></td>
                    <td><a href="updatebook.html?bookId=<c:out value="${alog.tsbh}"></c:out>"><button type="button" class="btn btn-info btn-xs">编辑</button></a></td>
                    <td><a href="addbook.html"><button type="button" class="btn btn-success btn-xs">增加</button></a></td>
                    <td><a href="deletebook.html?bookId=<c:out value="${alog.tsbh}"></c:out>"><button type="button" class="btn btn-danger btn-xs">删除</button></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

</body>
</html>
