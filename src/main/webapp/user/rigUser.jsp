<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024-07-06
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>用户注册</title>

    <%@ include file="../header.jsp" %>
    <script>
        function validateForm() {
            let password = document.getElementById("password").value;
            let confirmPassword = document.getElementById("confirmPassword").value;
            if (password !== confirmPassword) {
                alert("两次输入的密码不一致");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <h2 class="text-center">注册账号</h2>
    <form class="form-horizontal" action="Student/register" method="post" onsubmit="return validateForm();">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
        </div>
        <div class="form-group">
            <label for="userName" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="userName" name="userName" required>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
        </div>
        <div class="form-group">
            <label for="confirmPassword" class="col-sm-2 control-label">确认密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
            </div>
        </div>
        <div class="form-group">
            <label for="age" class="col-sm-2 control-label">年龄</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="age" name="age" required>
            </div>
        </div>
        <div class="form-group">
            <label for="school" class="col-sm-2 control-label">学校</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="school" name="school" required>
            </div>
        </div>
        <div class="form-group">
            <label for="info" class="col-sm-2 control-label">信息</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="info" name="info" required>
            </div>
        </div>
        <div class="form-group">
            <label for="tel" class="col-sm-2 control-label">电话</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="tel" name="tel" required>
            </div>
        </div>
        <div class="form-group">
            <label for="gender" class="col-sm-2 control-label">性别</label>
            <div class="col-sm-10">
                <select class="form-control" id="gender" name="gender" required>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">注册</button>
            </div>
        </div>
    </form>
</div>
<script>
    $(document).ready(function() {
        $('#registerModal').modal('show');
    });
</script>
</body>
</html>
