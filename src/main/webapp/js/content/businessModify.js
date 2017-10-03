function modify() {
	$("#mainForm").submit();
}

$(function() {
	common.showMessage($("#message").val());
	$("#mainForm").validate({
		rules : {
			"title" : "required",
			"subtitle" : "required",

		},
		messages : {
			"title" : "请输入标题！",
			"subtitle" : "请输入副标题！"
		}
	});
});

function goback() {
	location.href =  '/businesses';
}