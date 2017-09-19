<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE"/>
		<title></title>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/all.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/pop.css"/>
		<link rel="stylesheet" type="text/css" href="${basePath}/css/main.css"/>
	</head>
	<body style="background: #e1e9eb;">
		<form id="mainForm" method="post">
			<div class="right">
				<div class="current">当前位置：<a href="###">内容管理</a> &gt; 广告管理</div>
				<div class="rightCont">
					<p class="g_title fix">新增广告</p>
					<table class="tab1" width="100%">
						<tbody><tr>
							<td align="right" width="10%">标题<font color="red">*</font>：</td>
							<td width="30%">
								<input id="title" value="学钢琴" name="title" class="allInput" style="width:100%;" type="text"/>
							</td>
							<td align="right" width="10%">链接地址<font color="red">*</font>：</td>
							<td width="30%">
								<input id="link" name="link" value="http://www.imooc.com/wap/index" class="allInput" style="width:100%;" type="text"/>
							</td>
						</tr>
					</tbody></table>
					<div style="text-align: center; margin-top: 30px;">
						<input class="tabSub" value="保     存" type="button"/>&nbsp;&nbsp;&nbsp;&nbsp;
						<input class="tabSub" value="返     回" type="button"/>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>