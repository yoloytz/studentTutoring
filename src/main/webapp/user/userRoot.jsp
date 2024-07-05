<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024-07-05
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <%--    <base href="/项目名/">--%>
    <base href="<%=basePath%>">
    <title>用户登录系统</title>
</head>
<body>
<%@ include file="../header.jsp" %>
<c:set var="pageTitle" value="用户登录" />
<div class="container">
    <h1 class="text-center">学生/家长登录</h1>
    <form action="Student/logStudent" method="post" class="form-horizontal">
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">账号:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码:</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">登录</button>
            </div>
        </div>
    </form>
</div>
<a href="index.jsp">返回</a>
</body>
</html>
