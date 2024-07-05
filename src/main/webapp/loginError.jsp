<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024-07-05
  Time: 15:58
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
    <title>错误</title>
</head>
<body>
<h1>
    ${ErrorText}
    <a href="index.jsp">返回</a>
</h1>

</body>
</html>
