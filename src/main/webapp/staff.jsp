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
				<form action="<%=request.getContextPath()%>/staff/index/1" method="post" class=" row">
					<input type="hidden" name="s_id" />
					<div class="form-group">
						<label>名字</label>
						<input type="text" class=" form-control" name="s_name" />
					</div>
					<div class="form-group">
						<label>性别</label>
						<select name="sex"  class="form-control">
							<option value=""></option>
							<option value ="男" <c:if test="${staff.sex=='男'}">selected</c:if> > 男</option>
							<option value ="女"  <c:if test="${staff.sex=='女'}">selected</c:if>   >女</option>
						</select>
					</div>


					<div class="form-group">
						<label>职位</label>
						<select name="j_id"  class="form-control">
							<option value=""></option>
							<c:forEach items="${job}" var="i">
								<c:choose>
									<c:when test="${i.j_id==staff.j_id}"><option selected value ="${i.j_id}">${i.j_name}</option></c:when>
									<c:otherwise>
										<option  value ="${i.j_id}">${i.j_name}</option>
									</c:otherwise>
								</c:choose>

							</c:forEach>

						</select>
					</div>
					<div class="form-group">
						<label>学历</label>
						<select name="school"  class="form-control">
							<option value=""></option>
							<option value ="大专" <c:if test="${staff.school=='大专'}">selected</c:if> >大专</option>
							<option value ="本科" <c:if test="${staff.school=='本科'}">selected</c:if> >本科</option>
							<option value ="研究生"<c:if test="${staff.school=='研究生'}">selected</c:if> >研究生</option>
							<option value ="博士"<c:if test="${staff.school=='博士'}">selected</c:if> >博士</option>

						</select>
					</div>

					<div class="form-group"  class="form-control">
						<label>部门</label>
						<select name="d_id"  class="form-control">
							<option value=""></option>
							<c:forEach items="${dept}" var="i">
								<c:choose>
									<c:when test="${i.d_id==staff.d_id}"><option selected value ="${i.d_id}">${i.d_name}</option></c:when>
									<c:otherwise>
										<option value ="${i.d_id}">${i.d_name}</option>
									</c:otherwise>
								</c:choose>

							</c:forEach>
						</select>
					</div>

					<button type="submit" class="btn">查询</button>
				</form>
			<table class="table table-hover">
				<thead>
					<tr>
						
						<th>员工名称</th>
						<th>性别</th>
						<th>电话</th>
						<th>邮箱</th>
						<th>职位</th>
						<th>学历</th>
						<th>身份证</th>
						<th>部门</th>
						<th>住址</th>
						<th>入职时间</th>
						<th>操作</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="i">
						<tr>
							<td>${i.s_name}</td>
							<td>${i.sex}</td>
							<td>${i.phone}</td>
							<td>${i.email}</td>
							<td>${i.j_name}</td>
							<td>${school}</td>
							<td>${i.card}</td>
							<td>${i.d_name}</td>
							<td>${lu}</td>
							<td><fmt:formatDate value="${i.jointime}"/></td>
							<td>
								<div class="btn-group border " style="border-radius: 30px;">
									<button type="button" class="btn "  data-toggle="modal" data-target="#modeldemo">新增</button>
									<button type="button" class="btn " data-toggle="modal" data-target="#modeldemo"  data-whatever="${i.s_id}">修改</button>
									<button type="button" class="btn " onclick="remove(this,${i.s_id})">删除</button>

								</div>
							</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>

		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${p.hasPreviousPage}">
					<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/staff/index/${p.pageNum-1}">Previous</a></li>
				</c:if>
				<li class="page-item"><a class="page-link" href="#">${p.pageNum}</a></li>
				<c:if test="${p.hasNextPage}">
					<li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/staff/index/${p.pageNum+1}">Next</a></li>
				</c:if>
			</ul>
		</nav>

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

						<form id="form" action="" method="post" class=" row">
							<input type="hidden" name="s_id" id="s_id"  />
							<div class="form-group">
								<label>名字</label>
								<input type="text" class=" form-control" name="s_name" id="s_name" value="${staff.s_name}"/>
							</div>
							<div class="form-group">
								<label>性别</label>
								<select name="sex" id="sex"  class="form-control">
									<option value ="男">男</option>
									<option value ="女">女</option>
								</select>
							</div>
							<div class="form-group">
								<label>电话</label>
								<input type="text" class=" form-control" name="phone" id="phone"/>
							</div>
							<div class="form-group">
								<label>邮箱</label>
								<input type="email" class=" form-control" name="email" id="email"/>
							</div>
							<div class="form-group">
								<label>职位</label>
								<select name="j_id" id="j_id" class="form-control">
									<c:forEach items="${job}" var="i">
										<option name="job" value ="${i.j_id}">${i.j_name}</option>
									</c:forEach>

								</select>
							</div>
							<div class="form-group">
								<label>学历</label>
								<select name="school" id="school"  class="form-control">
									<option value ="大专">大专</option>
									<option value ="本科">本科</option>
									<option value ="研究生">研究生</option>
									<option value ="博士">博士</option>

								</select>
							</div>
							<div class="form-group">
								<label>身份证</label>
								<input type="text" class=" form-control" name="card" id="card"/>
							</div>
							<div class="form-group"  class="form-control">
								<label>部门</label>
								<select name="d_id" id="d_id"  class="form-control">
									<c:forEach items="${dept}" var="i">
										<option name="dept" value ="${i.d_id}">${i.d_name}</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label>住址</label>
								<input type="text" class=" form-control" name="lu" id="lu"/>
							</div>
							<button type="submit">提交</button>

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
			$.post("<%=request.getContextPath()%>/staff/delete/"+a_id,function (result) {
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
				$("#form").attr({"action":ul+"/staff/update"});
				// console.log($("#form").attr("action"));
				// console.log($("#_method").val());

				$.get("<%=request.getContextPath()%>/staff/selectone/"+a_id,function (data) {
					console.log(data["s_id"]);
					console.log(data["s_name"]);
					$("#s_id").val(data["s_id"]);
					$("#s_name").val(data["s_name"]);
					$("#phone").val(data["phone"]);
					$("#email").val(data["email"]);
					$("[name='job'][value="+data[j_id]+"]").eq(1).attr("selected");
					$("[name='dept'][value="+data[d_id]+"]").eq(1).attr("selected")
					$("[value="+data[school]+"]").eq(1).attr("selected")
					$("#card").val(data["card"]);
					$("#lu").val(data["lu"]);
				})
			}
			else{
				modal.find('.modal-title').text('新增学员信息');
				$("#form").attr({"action":ul+"/staff/add"});

				$("#s_id").val("");
				$("#s_name").val("");
				$("#phone").val("");
				$("#email").val("");
				$("#school").val("");
				$("#j_id").val("");
				$("#d_id").val("");
				$("#card").val("");
				$("#lu").val("");

			}


			//modal.find('.modal-body input').val(recipient)
		})
	</script>
</html>
