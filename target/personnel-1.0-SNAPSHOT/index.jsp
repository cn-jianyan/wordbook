<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt"
		   uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/dist/css/bootstrap.css"/>
		<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath()%>/dist/js/bootstrap.bundle.js" type="text/javascript" charset="utf-8"></script>

	</head>
	<style type="text/css">
		button:hover{
			background-color: yellow;
		}
	</style>
	<body style="height: 100%">
		
		<div class="container">
			<div class="row clearfix mt-3 mb-3">
				<div class="col-md-12 column">
					<h3>
						人事管理系统
					</h3>
					
				</div>
			</div>
			<div class="row clearfix">
				<div class="col-md-2 column">
					<div class="list-group ">
						<a href="#" class="list-group-item active"></a>
						<shiro:hasPermission name="admin:view">
							<a href="<%=request.getContextPath()%>/admin/index" class="list-group-item text-black-50" target="win">用户</a></shiro:hasPermission>
						<shiro:hasPermission name="dept:view">
							<a href="<%=request.getContextPath()%>/dept/index" class="list-group-item  text-black-50" target="win">部门</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="job:view">
							<a href="<%=request.getContextPath()%>/job/index" class="list-group-item  text-black-50" target="win">工作</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="file:view">
							<a href="<%=request.getContextPath()%>/file/index/1" class="list-group-item  text-black-50" target="win">文件</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="notice:view">
							<a href="<%=request.getContextPath()%>/notice/index/1" class="list-group-item  text-black-50" target="win">通告</a>
						</shiro:hasPermission>
						<shiro:hasPermission name="staff:view">
							<a href="<%=request.getContextPath()%>/staff/index/1" class="list-group-item  text-black-50" target="win">员工</a>
						</shiro:hasPermission>

					</div>
				</div>
				<div class="col-md-10 column">
					<iframe name="win" class="row innerbox" frameborder="0" scrolling="auto" src="<%=request.getContextPath()%>/admin/index" width="100%" height="500px" style="border: medium none;"></iframe>
				</div>
			</div>
		</div>
	</body>
</html>
