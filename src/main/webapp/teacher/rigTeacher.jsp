<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>教师注册</title>
    <%@ include file="../header.jsp" %>
    <script>
        function validateForm() {
            let password = document.getElementById("teacherPassword").value;
            let confirmPassword = document.getElementById("confirmTeacherPassword").value;
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
    <h2 class="text-center">注册教师账号</h2>
    <form class="form-horizontal" action="Teacher/register" method="post" onsubmit="return validateForm();">
        <div class="form-group">
            <label for="teacherName" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="teacherName" name="teacherName" required>
            </div>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
        </div>
        <div class="form-group">
            <label for="teacherPassword" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="teacherPassword" name="teacherPassword" required>
            </div>
        </div>
        <div class="form-group">
            <label for="confirmTeacherPassword" class="col-sm-2 control-label">确认密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="confirmTeacherPassword" name="confirmTeacherPassword" required>
            </div>
        </div>
        <div class="form-group">
            <label for="age" class="col-sm-2 control-label">年龄</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="age" name="age" required>
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
            <label for="school" class="col-sm-2 control-label">学校</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="school" name="school" required>
            </div>
        </div>
        <div class="form-group">
            <label for="state" class="col-sm-2 control-label">状态:在职or在校</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="state" name="state" required>
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
