<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt"
		   uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/dist/css/bootstrap.css"/>
		<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath()%>/dist/js/bootstrap.bundle.js" type="text/javascript" charset="utf-8"></script>

	</head>
	<body>
		<div class="container-fluid">
			<table class="table table-hover">
				<thead>
					<tr>
						
						<th>
							用户名
						</th>
						<th>
							密码
						</th>
						<th>
							姓名
						</th>
						<th>
							状态
						</th>
						<th>
							创建时间
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="i">
						<tr>

							<td>
								${i.a_user}
							</td>
							<td>
									${i.pwd}
							</td>
							<td>
									${i.a_name}
							</td>
							<td>
									${i.state}
							</td>
							<td>
								<fmt:formatDate value="${i.jointime}"/>
							</td>
							<td>
								<div class="btn-group border " style="border-radius: 30px;">
									<button type="button" class="btn "  data-toggle="modal" data-target="#modeldemo">新增</button>
									<button type="button" class="btn " data-toggle="modal" data-target="#modeldemo"  data-whatever="${i.a_id}">修改</button>
									<button type="button" class="btn " onclick="delete(this,${i.a_id})">删除</button>
									<a type="button" class="btn" href="<%=request.getContextPath()%>/admin/power/${i.a_id}/${i.a_user}">权限管理</a>
								</div>
							</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="modeldemo" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-scrollable" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalScrollableTitle">Modal title</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body" style="height: 500px">

							<form id="form" action="" method="post"  role="form" class="container-fluid">
								<input type="hidden" name="a_id" id="a_id" value="">
								<%--<input type="hidden" name="_method" id="_method" value="">--%>
								<div class="form-group row">
									<label>用户名</label>
									<input type="text" class="form-inline" id="a_user" name="a_user">
								</div>
								<div class="form-group row">
									<label>密码</label>
									<input type="text" class="form-inline" id="pwd" name="pwd">
								</div>
								<div class="form-group row">
									<label>姓名</label>
									<input type="text" class="form-inline" id="a_name" name="a_name">
								</div>
								<div class="form-group row">
									<label>状态</label>
									<select name="state" id="state">
										<option value="0">未激活</option>
										<option value="1">激活</option>

									</select>
								</div>
								<button type="submit" class="btn active btn-primary">提交</button>
							</form>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>

					</div>
				</div>
			</div>
		</div>
	</body>
<script type="text/javascript">
	function  remove(b,a) {
		var tr=b.parentNode.parentNode.parentNode;
		var a_id=a;
		console.log(a_id);
		$.post("<%=request.getContextPath()%>/admin/delete",{'a_id':a_id,"_method":"delete"},function (result) {
			if(result==1){
				alert("删除成功");
				tr.remove();
			}
			else alert("删除失败");
		},"text");


	}


	//模态窗口
	var ul="<%=request.getContextPath()%>";
	$('#modeldemo').on('show.bs.modal', function (event) {
		var button = $(event.relatedTarget) // Button that triggered the modal
		var a_id= button.data('whatever') // Extract info from data-* attributes
		// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		var modal = $(this);
		if(a_id){
			//修改
			console.log(a_id);
			modal.find('.modal-title').text('修改学员信息');
			$("#form").attr({"action":ul+"/admin/update"});
			console.log($("#form").attr("action"));
			// console.log($("#_method").val());
			$("#_method").val("put");
			$.get("<%=request.getContextPath()%>/admin/selectone/"+a_id,function (data) {
				console.log(data);
				console.log(data["a_id"]);
				$("#a_id").val(data["a_id"]);
				$("#a_name").val(data["a_name"]);
				$("#a_user").val(data["a_user"]);
				$("#pwd").val(data["pwd"]);
				$("option[value='"+data["state"]+"']").attr("selected");
			})
		}
		else{
			modal.find('.modal-title').text('新增学员信息');
			$("#form").attr({"action":ul+"/admin/add"});
			// $("#_method").val("");
				$("#a_id").val("");
			$("#a_name").val("");
			$("#a_user").val("");
			$("#pwd").val("");
			$("#state").val("");


		}


		//modal.find('.modal-body input').val(recipient)
	})
</script>
</html>
