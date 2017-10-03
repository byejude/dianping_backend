$(function() {
	common.showMessage($("#message").val());
});

function remove(id) {
	$("#mainForm").attr("action",$("#basePath").val() + "/businesses/" + id);
	$("#mainForm").submit();
}

// function search() {
// 	$("#mainForm").attr("method","GET");
// 	$("#mainForm").attr("action",$("#basePath").val() + "/businesses");
// 	$("#mainForm").submit();
// }

function search(currentPage) {
	console.log("${searchParam.title}");
	$("#mainForm").attr("method","GET");
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}


function modifyInit(id) {
	location.href = $("#basePath").val() + "/businesses/" + id;
}

$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
	$("#mainForm").validate({
		rules : {
			title : "required",
			link : "required",
			weight : {
				required : true,
				digits : true,
				maxlength : 5
			}

		},
		messages : {
			"title" : "请输入标题！"
		}
	});
});