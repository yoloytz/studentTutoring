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
    <!-- 使用EL表达式正确访问模型对象 -->
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="../header.jsp" %>
    <c:set var="pageTitle" value="管理员视图" />

    <c:if test="${not empty message}">
        <div class="alert alert-success" role="alert">
                ${message}
        </div>
    </c:if>
    <h2>欢迎, <c:out value="${admin.rootName}" /></h2>
    <h3>您是管理员，开始审核订单吧！</h3>
        <!-- 查看和管理所有订单 -->
        <div class="panel panel-default">
            <div class="panel-heading">订单管理</div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>订单名</th>
                        <th>订单信息</th>
                        <th>授课方式</th>
                        <th>状态</th>
                        <th>申请用户</th>
                        <th>授课时间</th>
                        <th>授课地点</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="classInfo" items="${classesList}">
                        <tr>
                            <td><c:out value="${classInfo.className}" /></td>
                            <td><c:out value="${classInfo.classInfo}" /></td>
                            <td><c:out value="${classInfo.classMode}" /></td>
                            <td><c:out value="${classInfo.state}" /></td>
                            <td><c:out value="${classInfo.classStudentId}" /></td>
                            <td><c:out value="${classInfo.classTime}" /></td>
                            <td><c:out value="${classInfo.classPlace}" /></td>
                            <td>
                                <form action="root/approveOrder" method="post" style="display:inline;">
                                    <input type="hidden" name="classId" value="${classInfo.classId}">
                                    <button type="submit" class="btn btn-success">通过</button>
                                </form>
                                <form action="root/deleteOrder" method="post" style="display:inline;">
                                    <input type="hidden" name="classId" value="${classInfo.classId}">
                                    <button type="submit" class="btn btn-danger">删除</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


<%--    <%@ include file="footer.jsp" %>--%>


</body>
</html>
