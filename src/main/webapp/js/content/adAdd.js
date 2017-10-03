$(function() {
	common.showMessage($("#message").val());

});
function add() {

		$("#mainForm").submit();

}




function goback() {
	location.href = $('#basePath').val() + '/ad';
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