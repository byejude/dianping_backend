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
		<form action="" id="mainForm" method="post">
			<div class="right">
				<div class="current">当前位置：<a href="#">内容管理</a> &gt; 广告管理</div>
				<div class="rightCont">
					<p class="g_title fix">广告列表</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td align="right" width="80">标题：</td>
								<td>
									<input id="title" value="" class="allInput" type="text"/>
								</td>
	                            <td style="text-align: right;" width="150">
	                            	<input class="tabSub" value="查询" onclick="" type="button"/>&nbsp;&nbsp;&nbsp;&nbsp;
	                            	<input class="tabSub" value="添加" onclick="location.href='edit.html'" type="button"/>
	                            </td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th>序号</th>
								    <th>标题</th>
								    <th>链接地址</th>
								    <th>操作</th>
								</tr>
								
									<tr>
										<td>1</td>
										<td>学钢琴</td>
										<td>http://www.imooc.com/wap/index</td>
										<td>
											<a href="javascript:void(0);">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="javascript:void(0);">删除</a>
										</td>
									</tr>
								
									<tr>
										<td>2</td>
										<td>特价出国</td>
										<td>http://www.imooc.com/wap/index</td>
										<td>
											<a href="javascript:void(0);">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="javascript:void(0);">删除</a>
										</td>
									</tr>
								
									<tr>
										<td>3</td>
										<td>暑假5折</td>
										<td>http://www.imooc.com/wap/index</td>
										<td>
											<a href="javascript:void(0);">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="javascript:void(0);">删除</a>
										</td>
									</tr>
								
									<tr>
										<td>4</td>
										<td>旅游热线</td>
										<td>http://www.imooc.com/wap/index</td>
										<td>
											<a href="javascript:void(0);">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="javascript:void(0);">删除</a>
										</td>
									</tr>
								
									<tr>
										<td>5</td>
										<td>亮亮车</td>
										<td>http://www.imooc.com/wap/index</td>
										<td>
											<a href="javascript:void(0);">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="javascript:void(0);">删除</a>
										</td>
									</tr>
								
							</tbody>
						</table>
						
						<!-- 分页 -->
						<div class="page fix">
							<a href="###" class="first">首页</a>
							<a href="###" class="pre">上一页</a>
							当前第<span>1/2</span>页
							<a href="###" class="next">下一页</a>
							<a href="###" class="last">末页</a>
							跳至 &nbsp;<input value="1" class="allInput w28" type="text"/>&nbsp;页 &nbsp;
							<a href="###" class="go">GO</a>
						</div>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>