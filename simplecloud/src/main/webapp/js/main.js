//var token = localStorage.getItem("token");

// 登陆用户头像昵称
//showLoginInfo();
//function showLoginInfo() {
//	$.ajax({
//		type : 'get',
//		url : '/users/current?token=' + token,
//		async : false,
//		success : function(data) {
//			$("#userName").text(data.nickname);
//			var pro = window.location.protocol;
//			var host = window.location.host;
//			var domain = pro + "//" + host;
//
//			var sex = data.sex;
//			var url = data.headImgUrl;
//			if (url == null || url == "") {
//				if (sex == 1) {
//					url = "/img/avatars/sunny.png";
//				} else {
//					url = "/img/avatars/1.png";
//				}
//
//				url = domain + url;
//			} else {
//				url = domain + "/statics" + url;
//			}
//			var img = $("#userimg");
//			img.attr("src", url);
//		}
//	});
//}
currentSpace();
function currentSpace() {
	$.ajax({
		type : 'get',
		url : 'file/getAllFilesSize',
		async : true,
		success : function(data) {
			//			alert(data)
			$("#spaceDiv").attr("aria-valuenow", (data / 1024 / 1024 / 1024).toFixed(2) + "GB");
			$("#spaceDiv").attr("aria-valuemax", 10 + "GB"); //默认总空间为10G
			var availableSpace = (data / 1024 / 1024 / 1024).toFixed(2) / 10 * 100;
			$("#spaceDiv").html(availableSpace + "%")
			$("#spaceDiv").width(availableSpace + "%");
			$("#availableSpace").html((10 - (data / 1024 / 1024 / 1024).toFixed(2)) + "GB");
			$("#usedSpace").html((data / 1024 / 1024 / 1024).toFixed(2) + "GB");
			$("#totalSpace").html(10 + "GB");
		}
	});
}

$(function() {
	//预览
	$("#preview").click(function() {
		var files = $('#fileTable').bootstrapTable('getSelections');
		if (files.length <= 0) {
			swal('请选择一条数据进行预览');
			return;
		}
		if (files.length >= 2) {
			swal('只能选择其中一条数据进行预览');
			return;
		}
		var fileName = files[0].fileName;
		var endWith = fileName.substring(fileName.lastIndexOf("."), fileName.length).toLowerCase();
		if (endWith == ".mp3" || endWith == ".wma" || endWith == ".mp4" || endWith == ".jpg" || endWith == ".png" || endWith == ".gif" || endWith == ".pdf" || endWith == ".txt") {
			$("#myModal").modal('show');
			$.ajax({
				type : 'get',
				url : 'file/preview',
				data : 'fileName=' + fileName,
				async : false,
				success : function(data) {
					if (data != null) {
						var preview;
						if (fileName.endsWith(".mp3") || fileName.endsWith(".mp4")) {
							preview = "<video controls='true' autoplay='true' style='width: 100%;height: 100%;' src='" + data + "'></video>";
						} else if (fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png")) {
							preview = "<img style='width:100%;height: 140%;' src='" + data + "'></img>";
						} else if (fileName.endsWith(".pdf") || fileName.endsWith(".txt")) {
							preview = "<iframe style='width:100%;height: 100%;' src='" + data + "'></iframe>";
							if (fileName.endsWith(".txt")) {
								$(".modal-header").append("文本文件不是UFT-8字符集会显示乱码").css({
									'text-align' : "center",
									"color" : "red"
								});
							}
							$("#modal").css({
								width : "60%",
								height : "135%"
							});
						}
						$("#previewArea").html(preview);
					} else {
						swal('网络不稳定,请稍后重试');
					}
				}
			});
		} else {
			swal('此文件格式暂时不支持在线预览');
		}
	});


	//删除临时预览产生的文件
	$("#closeButton").click(function() {
		$("#previewArea").empty(); //html("");
		var fileName = '修图.jpg';
		$.ajax({
			type : 'get',
			url : 'file/removeTempFile',
			data : 'fileName=' + fileName,
			async : false,
			success : function() {
				console.log("删除完成");
			}
		});

	});



	/** 拖拽模态框*/
	/*var mouseStartPoint = {
		"left" : 0,
		"top" : 0
	};
	var mouseEndPoint = {
		"left" : 0,
		"top" : 0
	};
	var mouseDragDown = false;
	var oldP = {
		"left" : 0,
		"top" : 0
	};
	var moveTartet;
	$(document).on("mousedown", ".modal-header", function(e) {
		if ($(e.target).hasClass("close")) //点关闭按钮不能移动对话框
			return;
		mouseDragDown = true;
		moveTartet = $(this).parent();
		mouseStartPoint = {
			"left" : e.clientX,
			"top" : e.clientY
		};
		oldP = moveTartet.offset();
	});
	$(document).on("mouseup", function(e) {
		mouseDragDown = false;
		moveTartet = undefined;
		mouseStartPoint = {
			"left" : 0,
			"top" : 0
		};
		oldP = {
			"left" : 0,
			"top" : 0
		};
	});
	$(document).on("mousemove", function(e) {
		if (!mouseDragDown || moveTartet == undefined) return;
		var mousX = e.clientX;
		var mousY = e.clientY;
		if (mousX < 0)
			mousX = 0;
		if (mousY < 0)
			mousY = 25;
		mouseEndPoint = {
			"left" : mousX,
			"top" : mousY
		};
		var width = moveTartet.width();
		var height = moveTartet.height();
		mouseEndPoint.left = mouseEndPoint.left - (mouseStartPoint.left - oldP.left); //移动修正，更平滑
		mouseEndPoint.top = mouseEndPoint.top - (mouseStartPoint.top - oldP.top);
		moveTartet.offset(mouseEndPoint);
	});*/

});



/*function logout() {
	$.ajax({
		type : 'get',
		url : '/logout?token=' + token,
		success : function(data) {
			localStorage.removeItem("token");
			location.href = '/login.html';
		}
	});
}

var active;*/