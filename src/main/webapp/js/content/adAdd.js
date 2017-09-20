$(function() {
	common.showMessage($("#message").val());
});

function add() {
	if(check()) {
		$("#mainForm").submit();
	}
}

function check() {
	// TODO 需要添加表单验证
	return true;
}

function goback() {
	location.href = $('#basePath').val() + '/ad';
}