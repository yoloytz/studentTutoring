<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024-07-05
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>私教预约系统</title>
</head>
<body>
<%@ include file="header.jsp" %>
<c:set var="pageTitle" value="私教预约系统" />
<div class="container">
    <h1 class="text-center">欢迎进入私教预约系统</h1>
    <h2 class="text-center">请选择登录</h2>
    <div class="text-center">
        <a class="btn btn-primary" href="root/logRoot.jsp">管理员登录</a>
        <a class="btn btn-success" href="teacher/logTeacher.jsp">老师登录</a>
        <a class="btn btn-info" href="user/userRoot.jsp">学生/家长登录</a>
    </div>
</div>
</body>

</html>
