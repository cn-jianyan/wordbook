<%@ page import="java.util.Set" %>
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
<div class="container">
    <fieldset class="border row">
        <legend style="width: 100px;">权限管理</legend>
        <form action="<%=request.getContextPath()%>/admin/addpower" method="post" class="col-12">
            <input type="hidden" name="aid" value="${a_id}">
            <fieldset >
            <legend>角色管理</legend>
            <div>
               <c:forEach items="${role}" var="i" varStatus="xh">
                   <div class="form-check form-check-inline" >
                       <input class="form-check-input" type="checkbox" <c:if test="${i.checked==true}">checked="true"</c:if>  name="r" id="r${xh.index}" value="${i.rid}">
                       <label class="form-check-label small text-danger" for="r${xh.index}">${i.rname}</label>
                   </div>
               </c:forEach>
            </div>
        </fieldset>
            <fieldset >
                <legend>权限管理</legend>
                <c:forEach items="${power}" var="i" varStatus="xh">
                    <div class="form-check form-check-inline" >
                        <input class="form-check-input" type="checkbox" <c:if test="${i.checked==true}">checked="true"</c:if> name="p" id="p${xh.index}" value="${i.pid}">
                        <label class="form-check-label small text-danger" for="p${xh.index}">${i.pname}</label>
                    </div>
                </c:forEach>
                <div class="form-group">
                    <button type="submit" class="btn">提交</button>
                </div>
            </fieldset>
        </form>
    </fieldset>

</div>
</body>
</html>
