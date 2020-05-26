
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
    <%--<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js" type="text/javascript" charset="utf-8"></script>
  --%>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/dist/js/bootstrap.bundle.js" type="text/javascript" charset="utf-8"></script>

    <style type="text/css">
        .op{
            background:rgba(0.5,0,0,0.2);
        }
        input{
            height: 33px;
        }
        .btt:active{
            background-color: yellow;
        }
    </style>
</head>
<body style="height: 100%;">
<div class="container">
    <div class="row pt-5 text-danger ">
        人事管理系统
    </div>

</div>
<div class="container border  " style="padding: 15% 0px;" >


    <form id="ff" action="" method="post" class="row text-center justify-content-center" >
        <div class="form-group border border-dark  col-4" style="border-radius: 50px;" >
            <input type="text" class=" border-0 ml-5" style="outline: none;background-color:transparent;"  value="" name="a_user" placeholder="账号"/>
        </div>
        <div class="col-12"></div>
        <div class="form-group border border-dark  col-4" style="border-radius: 50px;" >
            <input type="password" class="border-0 ml-5" style="outline: none;background-color:transparent;"  value="" name="pwd" placeholder="密码"/>
        </div>
        <div class="col-12"></div>
        <div onclick="commit()" class="btt btn form-group border border-dark  col-2"  style="border-radius:50px;">
            登录
        </div>
    </form>
</div>
<script type="text/javascript">
    function commit(){
        var u=$("input").eq(1).val();
        var p=$("input").eq(2).val();
        console.log(u+":"+p);
        $.ajax({
            url:"<%=request.getContextPath()%>/admin/sign",
            data:{a_user:u,pwd:p} ,/* $("#ff").serialize(),*/
            type:"post",
            success:function (data) {
                if (data=="1"){
                    location.href="<%=request.getContextPath()%>/index.jsp";
                }
                else if (data!="1") {
                    alert("账号或密码错误");
                }
            }
        })

    }
</script>
</body>

</html>

