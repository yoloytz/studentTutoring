<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024-07-05
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<%--<head>--%>
<%--    &lt;%&ndash;    <base href="/项目名/">&ndash;%&gt;--%>
<%--    <base href="<%=basePath%>">--%>
<%--    <title>管理员界面</title>--%>
<%--</head>--%>

<head>
    <meta charset="UTF-8">
    <title>管理员界面</title>
    <!-- 使用模板引擎设置基础URL -->
    <base href="${pageContext.request.contextPath}/">
    <!-- 引入Bootstrap CSS -->
    <link rel="stylesheet" href="../asserts/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
</head>
<body>
<div class="container">
    <h1>登录成功</h1>
    <h2>信息</h2>
    <!-- 使用EL表达式正确访问模型对象 -->
    <h3>${RootInfo.toString()}</h3>
</div>
</body>
</html>
