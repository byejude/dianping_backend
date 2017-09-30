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

function reek(args) {
	alert(args);

}
function modifyInit(id) {
	location.href = $("#basePath").val() + "/businesses/" + id;
}