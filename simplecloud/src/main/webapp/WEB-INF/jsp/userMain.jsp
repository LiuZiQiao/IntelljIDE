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
	<%-- <base th:href="${#request.getContextPath()}+'/'" /> --%>
	<link rel="shortcut icon" href="assets/images/cloud.ico">
	<title>简·存取</title>

<link href="assets/plugins/modal-effect/css/component.css" rel="stylesheet">
<link href="assets/plugins/sweetalert/dist/sweetalert.css" rel="stylesheet" type="text/css">
<link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="assets/css/core.css" rel="stylesheet" type="text/css">
<link href="assets/css/icons.css" rel="stylesheet" type="text/css">
<link href="assets/css/components.css" rel="stylesheet" type="text/css">
<link href="assets/css/pages.css" rel="stylesheet" type="text/css">
<link href="assets/css/menu.css" rel="stylesheet" type="text/css">
<link href="assets/css/responsive.css" rel="stylesheet" type="text/css">
<link href="file/css/fileinput.min.css" rel="stylesheet" type="text/css">
<link href="assets/css/bootstrap-table.min.css" rel="stylesheet" type="text/css" />
<script src="assets/js/modernizr.min.js"></script>
</head>
<body class="fixed-left">

	<!-- Begin page -->
	<div id="wrapper">

		<!-- Top Bar Start -->
		<div class="topbar">
			<!-- LOGO -->
			<div class="topbar-left">
				<div class="text-center">
					<a href="index.html" class="logo"><i class="md md-cloud-queue"></i> <span>简·存取</span></a>
				</div>
			</div>
			<div class="navbar navbar-default" role="navigation">
				<div class="container">
					
					<!-- <div class="pull-left">
						<button class="button-menu-mobile open-left">
							<i class="fa fa-bars"></i>
						</button>
					</div> -->
					<!-- 原来的搜索框  -->
					<!-- <div class="input-group" style="width: 30%; line-height: 70px;">
						<input type="text" id="keywords" class="form-control" placeholder="输入关键字即可全文检索..."> 
						<span class="input-group-btn">
							<button id="search" type="button" class="btn waves-effect waves-light btn-primary">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div> -->
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
					<img src="assets/images/users/avatar-3.jpg" alt="" class="thumb-md img-circle">
				</div>
				<div class="user-info">
					<div class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span id="userName">${user.nickname}</span>
						<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="javascript:void(0)"><i class="md md-settings"></i> 个人设置</a></li>
							<!--<li><a href="javascript:void(0)"><i class="md md-lock"></i> 锁&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;屏</a></li>-->
							<li><a href="user/logout"><i class="md md-settings-power"></i> 注销登录</a></li>
						</ul>
					</div>

					<p class="text-muted m-0">普通用户</p>
				</div>
			</div>
			<!--- Divider -->
			<div id="sidebar-menu">
				<ul>
					<li class="has_sub"><a href="index.html" class="waves-effect waves-light"><i class="fa fa-file-text-o m-r-5"></i> <span>全部文件</span> <span
							class="pull-right"><i class="md md-add"></i></span></a>
						<ul class="list-unstyled">
							<li><a href="gallery.html">图片</a></li>
							<li><a href="#">文档</a></li>
							<li><a href="#">视频</a></li>
							<li><a href="#">音乐</a></li>
							<li><a href="#">其他</a></li>

						</ul></li>

					<li><a href="recycleBin.html" class="waves-effect waves-light"><i class="fa fa-trash-o m-r-5"></i><span>回收站</span></a></li>

					<li><a href="#" class="waves-effect waves-light"><i class="fa fa-paper-plane-o m-r-5"></i><span>收到的分享</span></a></li>

					<li class="has_sub"><a href="#" class="waves-effect waves-light"><i class="fa fa-star-o m-r-5"></i><span>我的收藏</span></a></li>

					<li><a href="myShare.html" class="waves-effect waves-light"><i class="md md-share"></i><span>我的分享</span></a></li>
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
				<div class="row">
					<!-- 容量显示 -->
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									可用空间：<span id="availableSpace" style="margin-right: 10px"></span>
									 已用空间：<span id="usedSpace" style="margin-right: 10px"></span> 
									 总空间：<span id="totalSpace"></span>
								</h4>

							</div>
							<div class="panel-body">
								<div class="progress progress-lg">
									<div id="spaceDiv" class="progress-bar progress-bar-purple" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100"
										style="width: 0%; background-color: #9f9797;color:gray">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 导航 -->
				<div class="col-lg-12 col-md-8">
					<div class="row">
						<div class="col-lg-12">
							<div class="btn-toolbar" role="toolbar">
								<div class="btn-group">
									<button id="download" type="button" class="btn btn-primary waves-effect waves-light">
										<i class="fa fa-download m-r-5"></i>下载
									</button>
									<button class="btn btn-primary waves-effect waves-light" data-toggle="modal" data-target="#uploadFile">
										<i class="md md-file-upload"></i> 上传
									</button>
									<button id="refresh" type="button" class="btn btn-primary waves-effect waves-light">
										<i class="md md-folder-open"></i> 新建文件夹
									</button>
									<button id="deleteFile" type="button" class="btn btn-primary waves-effect waves-light">
										<i class="fa fa-trash-o m-r-5"></i>删除
									</button>
									<button id="renameFile" title="重命名功能需要并行文件系统支持" type="button" class="disabled btn btn-primary waves-effect waves-light">重命名</button>
									
									<button id="preview" type="button" class="btn btn-primary waves-effect waves-light">预览</button>
								</div>
							</div>
						</div>
					</div>
					<!-- End row -->
					<!-- Start content -->
					<div class="panel">
						<div class="panel-body">
							<div class="row">
								<table id="fileTable"></table>
							<!-- 自定义表格，暂时没用 -->	
							<%-- <table  style="width: 70%;border:1px solid gray;border-collapse:collapse; ">
								<c:forEach var="file" items="${fileList}">
    								<tr>
    									<th>${file.fileName}</th>
    									<th>${file.fileSize}</th>
    									<th>${file.upLoadTime}</th>
    								</tr>
    							</c:forEach>
							</table> --%>
								
							</div>
						</div>
					</div>
					<!-- end: page 文件上传模态框 -->
					<div id="uploadFile" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title">文件上传<br/><span style="color:red;">友情提示：重名文件会被覆盖</span></h4>
								</div>
								<div class="modal-body">
									<div class="upload-wrap">
										<input id="file" name="file" type="file" multiple="multiple" />
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default waves-effect" onclick="closeModal('uploadFile')">关闭</button>
								</div>
							</div>
						</div>
					</div>
	<!-- 除office之外的文件预览模态框开始 -->
	<!-- data-backdrop="static" 点击空白处模态框不消失 -->
	<div data-backdrop="static" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div id="modal" class="modal-dialog data-backdrop="static" data-keyboard="false">
			<div class="modal-content">
			
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">
						<span id="closeButton">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel"></h4>
				</div>

				<div id="previewArea" class="modal-body" style="margin:0px;padding:0px;width: 100%;height: 60%;"></div>
			</div>
		</div>
	</div>
	<!-- 除office之外的文件预览模态框结束 -->				
				</div>
				<!-- end Panel -->
			</div>
		</div>
	</div>
	<!-- END wrapper -->
	<script>
		var resizefunc = [];
	</script>
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
	<!-- Modal-Effect -->
	<script src="assets/plugins/modal-effect/js/classie.js"></script>
	<script src="assets/plugins/modal-effect/js/modalEffects.js"></script>
	<script src="file/js/fileinput.min.js"></script>
	<script src="file/js/locales/zh.js "></script>
	<script src="assets/js/bootstrap-table.min.js"></script>
	<script src="assets/js/bootstrap-table-zh-CN.min.js"></script>
	<!-- Sweet-Alert 好看的弹窗  -->
	<script src="assets/plugins/sweetalert/dist/sweetalert.min.js"></script>
	<script src="assets/pages/jquery.sweet-alert.init.js"></script>
	<!-- 自己封装的js  -->
	<script  type="text/javascript" src="js/main.js"></script> 
	<script type="text/javascript">
    $(function () {
    //alert($.fn.jquery + "   页面里");
       /*  var token = localStorage.getItem("token");
        var username = localStorage.getItem("username");
        if (!token) {
            logout()
        }
        if (username == "admin") {
            location.href = '/login.html';
        } */
        
        
        
		//加载表格-刚进页面就有数据(初始化表格)
        $('#fileTable').bootstrapTable({
            url: '/file/getAllFiles',
            method: 'get',
            toolbar: '#toolbar',
            striped: true,
            cache: false,
            height:540,
            pagination: true,
            sidePagination: "server",
            pageNumber: 1,
            pageSize: 10,
            pageList: [5, 10, 20, 50, 'All'],
            showColumns: true,
            showRefresh: true,
            search:true,
           	
            /* paginationVAlign:'both',//上下都有分页按钮 */
            clickToSelect: true,
            uniqueId: "fileName",
            columns: [{checkbox: true, visible: true},
                {field: 'fileName', title: '文件名', width: '40%', align: 'left'},
                {field: 'fileSize', title: '文件大小', width: '30%', align: 'left'},
                {field: 'upLoadTime', title: '上传时间', width: '30%', align: 'left'}
            ],
            queryParams: function (params) {
                var queryData = {
                    pageSize: params.limit,  //pageSize对应Javabean中的属性
                    pageNumber: (params.offset/params.limit)+1,//pageSize对应Javabean中的属性
                    /* searchText: {param: $('#keywords').val()} */
                    //独立字段
                    keyWords:params.search
                };
                return queryData;
            }
        });
        
		//$('#fileTable').bootstrapTable('exportExcel');
		
        

		//下载--已实现
        $('#download').click(function () {
            var files = $('#fileTable').bootstrapTable('getSelections');
            if (files.length<=0) {
                swal('请选择一条数据进行下载');
                return;
            }
            if (files.length>1) {
                swal('请先选择其中一条数据进行下载,否则无法选择下载存储路径');
                return;
            }
            window.location.href ='file/download?fileName=' + files[0].fileName;            
        });
        
        //重命名--并行文件系统才支持(未实现)
        $("#renameFile").click(function() {
        	var files = $('#fileTable').bootstrapTable('getSelections');
        	swal({
            title:'重命名文件/文件夹',
            text:'重命名文件夹时请不要删除里面的文件，否则会导致重命名失败',
            type:'input',
            showCancelButton:true,
            closeOnConfirm:false,
            confirmButtonText:'确定',
            cancelButtonText:'取消',
            animation:'slide-from-top',
            //inputPlaceholder:files[0].fileName,
            inputValue:files[0].fileName
        },
        	function(inputValue){         		
           		//虽然文件名已回填，但不保证捣乱删空
           		if(inputValue==''){
               		swal.showInputError('文件名不能为空');
               		return false;
           		}else{
           	   		swal('非常好','您输入的内容是：'+inputValue,'success');
           	   		$.get('file/renameFile', {'oldFileName':files[0].fileName,'newFileName':inputValue}, function (data) {
                        swal("重命名成功!", "", "success");
                        $('#fileTable').bootstrapTable('refresh');
                        currentSpace();
                    }, 'json');
           		}
        	});
        });

		//删除文件 -已实现
        $('#deleteFile').click(function () {
         	var files = $('#fileTable').bootstrapTable('getSelections');
            if(files.length<=0){
                swal("请选择要删除的数据");
                return;
            }
            swal({
                title: "您确定要删除吗?",
                text: "删除后将无法恢复",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                closeOnConfirm: false,
                closeOnCancel: false
            }, function (isConfirm) {
                if (isConfirm) {
                    var objectKeys = '';
                    for (var i = 0; i < files.length; i++) {
                        objectKeys +=  files[i].fileName +',';
                    }
                    var params = {
                        //参数的名称：值
                        objectKeys: objectKeys.substring(0, objectKeys.length-1),
                    }
                    $.get('file/removeFile', params, function (data) {
                        swal("已删除!", "", "success");
                        $('#fileTable').bootstrapTable('refresh');
                        currentSpace();
                    }, 'json');
                } else {
                    swal("已取消", "", "error");
                }
            });
        });
        
		//文件输入（上传）--已实现
        $('#file').fileinput({
            language: 'zh',
            uploadUrl: '/file/upload',
            //allowedFileExtensions : [ 'doc', 'docx', 'txt' ],//接收的文件后缀
            //uploadExtraData:{"id": 1, "fileName":'123.mp3'},
            uploadAsync: true, //默认异步上传
            showUpload: true, //是否显示上传按钮
            showRemove: true, //显示移除按钮
            showPreview: true, //是否显示预览
            showCaption: true,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            dropZoneEnabled: false,//是否显示拖拽区域
            maxFileSize: 5242880,//5G,单位为kb，如果为0表示不限制文件大小
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
            msgSizeTooLarge: '文件 "{name}" (<b>{size} KB</b>) 超过了允许大小 <b>{maxSize} KB</b>.',
            msgInvalidFileExtension: '不正确的文件扩展名 "{name}". 只支持 "{extensions}" 的文件扩展名.',
        	autoReplace: true,
        /*上传成功之后运行*/
        }).on("fileuploaded", function (event, data, previewId, index) {
    		countDown();
         	var num=2;
    		var clear;
  			function countDown(){
  				num--;
  				clear=setTimeout(countDown,1000);
  				if(num==0){
  					clearTimeout(clear);
  					//两秒后清除之前预览的图片
         			$(event.target).fileinput('clear');
  				}
  			}
         	//message对应ResponseResult中的message
			console.log(data.response.message);
        });
    });
    
    	

    
    
    function closeModal(id) {
        $('#' + id).modal('hide');
        $('#fileTable').bootstrapTable('refresh');
    }

    function refresh() {
        $('#fileTable').bootstrapTable('refresh');
    }

    
    
    
    
    
    function sourceOpen(e, url, video, mediaSource) {
        debugger;
        URL.revokeObjectURL(video.src);
        // 设置 媒体的编码类型
        var mime = 'video/x-msvideo; codecs="vorbis,vp8"';
        var sourceBuffer = mediaSource.addSourceBuffer('video/mp4; codecs="avc1.4d401f,mp4a.40.2"');
        var videoUrl = url;
        fetch(videoUrl).then(function (response) {
            console.log(response)
            return response.arrayBuffer();
        }).then(function (arrayBuffer) {
            sourceBuffer.addEventListener('updateend', function (e) {
                if (!sourceBuffer.updating && mediaSource.readyState === 'open') {
                    mediaSource.endOfStream();
                    // 在数据请求完成后，我们需要调用 endOfStream()。它会改变 MediaSource.readyState 为 ended 并且触发 sourceended 事件。
                    video.play().then(function () {
                    }).catch(function (err) {
                        console.log(err)
                    });
                }
            });
            sourceBuffer.appendBuffer(arrayBuffer);
        });
    }
</script>


</body>
</html>
