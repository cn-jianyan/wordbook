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
    <form action="<%=request.getContextPath()%>/notice/mail/1" method="post" class=" row">
        <input type="hidden" name="a_id" value="${a_id}" />
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
            <th>全选 <input onclick="dan(this)" type="checkbox" value="" name="xxx"></th>

        </tr>
        </thead>
        <tbody>
        <form method="post" action="<%=request.getContextPath()%>/notice/sendmail/${n_id}">
<%--            <input type="hidden" name="n_id" value="${n_id}">--%>
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
                    <input type="checkbox" value="${i.email}" name="email">
                </td>
            </tr>
        </c:forEach>
            <button type="submit" class="btn border " >发送邮件</button>
        </form>
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

</div>
</body>
    <script type="text/javascript">
        function dan(e){
            var loves = document.getElementsByName("email");
            for(var i=0;i<loves.length;i++){
                loves[i].checked=e.checked;
            }
        }
    </script>
</html>
