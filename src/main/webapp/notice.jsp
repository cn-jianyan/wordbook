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
			<th>序号</th>
			<th>通知</th>
			<th>内容</th>
			<th>发布时间</th>
			<th>发布人</th>


		</tr>
		</thead>
		<tbody>
		<c:forEach items="${list}" var="i" varStatus="index">
			<tr>

				<td>${index.index}</td>
				<td>${i.n_name}</td>
				<td>${i.content}</td>
				<td><fmt:formatDate value="${i.jointime}"/></td>
				<td>${i.a_name}</td>

				<td>
					<div class="btn-group border " style="border-radius: 30px;">
						<button type="button" class="btn "  data-toggle="modal" data-target="#modeldemo">新增</button>
						<button type="button" class="btn " data-toggle="modal" data-target="#modeldemo"  data-whatever="${i.n_id}">修改</button>
						<button type="button" class="btn " onclick="remove(this,${i.n_id})">删除</button>
						<a href="<%=request.getContextPath()%>/notice/mail/1?n_id=${i.n_id}" class="btn">邮件发送</a>
					</div>
				</td>
			</tr>
		</c:forEach>

		</tbody>
	</table>
	<nav aria-label="Page navigation example">
		<ul class="pagination">
<c:if test="${p.hasPreviousPage}">
<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/notice/index/${p.pageNum-1}">Previous</a></li>
</c:if>
			<c:if test="${p.pageNum-2>1}">
				<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/notice/index/${p.pageNum-2}">${p.pageNum-1}</a></li>
			</c:if>
			<c:if test="${p.pageNum-1>1}">
				<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/notice/index/${p.pageNum-1}">${p.pageNum-1}</a></li>
			</c:if>
			<li class="page-item active"><a class="page-link" href="#">${p.pageNum}</a></li>
			<c:if test="${p.pageNum+1<p.pages}">
				<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/notice/index/${p.pageNum+1}">${p.pageNum+1}</a></li>
			</c:if>
			<c:if test="${p.pageNum+2<p.pages}">
				<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/notice/index/${p.pageNum+2}">${p.pageNum+2}</a></li>
			</c:if>
			<c:if test="${p.hasNextPage}">
			<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/notice/index/${p.pageNum+1}">Next</a></li>
		</c:if>
			</ul>
	</nav>
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
					<input type="hidden" name="n_id" id="n_id" value="">
					<%--<input type="hidden" name="_method" id="_method" value="">--%>
					<div class="form-group row">
						<label>通知</label>
						<input type="text" class="form-inline" id="n_name" name="n_name">
					</div>
					<div class="form-group row">
						<label>内容</label>
						<textarea name="content" id="content"></textarea>
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
		$.post("<%=request.getContextPath()%>/notice/delete/"+a_id,function (result) {
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
			$("#form").attr({"action":ul+"/notice/update"});
			// console.log($("#form").attr("action"));
			// console.log($("#_method").val());

			$.get("<%=request.getContextPath()%>/dept/selectone/"+a_id,function (data) {

				$("#n_id").val(data["n_id"]);
				$("#n_name").val(data["n_name"]);
				$("#content").val(data["content"]);

			})
		}
		else{
			modal.find('.modal-title').text('新增学员信息');
			$("#form").attr({"action":ul+"/notice/add"});
			// $("#_method").val("");
			$("#n_id").val("");
			$("#n_name").val("");
			$("#content").val("");


		}


		//modal.find('.modal-body input').val(recipient)
	})
</script>
</html>
