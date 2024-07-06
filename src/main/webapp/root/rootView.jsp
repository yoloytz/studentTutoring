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
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="../header.jsp" %>
    <c:set var="pageTitle" value="管理员视图" />

    <div class="container">
        <h1 class="text-center">管理员视图</h1>
        <h2>欢迎, <c:out value="${admin.rootName}" /></h2>

        <!-- 管理员信息查看和修改 -->
        <div class="panel panel-default">
            <div class="panel-heading">个人信息</div>
            <div class="panel-body">
                <form action="root/updateProfile" method="post" class="form-horizontal">
                    <div class="form-group">
                        <label for="rootName" class="col-sm-2 control-label">账号:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="rootName" name="rootName" value="${admin.rootName}" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">姓名:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name" value="${admin.name}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="info" class="col-sm-2 control-label">简介:</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="info" name="info" rows="3">${admin.info}</textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="tel" class="col-sm-2 control-label">电话:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="tel" name="tel" value="${admin.tel}">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-primary">更新信息</button>
                            <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#changePasswordModal">修改密码</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <!-- 查看和管理所有用户 -->
        <div class="panel panel-default">
            <div class="panel-heading">用户管理</div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>用户名</th>
                        <th>姓名</th>
                        <th>年龄</th>
                        <th>性别</th>
                        <th>学校</th>
                        <th>电话</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="user" items="${allUsers}">
                        <tr>
                            <td><c:out value="${user.userName}" /></td>
                            <td><c:out value="${user.name}" /></td>
                            <td><c:out value="${user.age}" /></td>
                            <td><c:out value="${user.gender}" /></td>
                            <td><c:out value="${user.school}" /></td>
                            <td><c:out value="${user.tel}" /></td>
                            <td>
                                <form action="root/deleteUser" method="post" style="display:inline;">
                                    <input type="hidden" name="userId" value="${user.userId}">
                                    <button type="submit" class="btn btn-danger">删除</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

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
                        <th>接单老师</th>
                        <th>授课时间</th>
                        <th>授课地点</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="class" items="${allOrders}">
                        <tr>
                            <td><c:out value="${class.className}" /></td>
                            <td><c:out value="${class.classInfo}" /></td>
                            <td><c:out value="${class.classMode}" /></td>
                            <td><c:out value="${class.state}" /></td>
                            <td><c:out value="${class.classStudentId}" /></td>
                            <td><c:out value="${class.classTeacherId}" /></td>
                            <td><c:out value="${class.classTime}" /></td>
                            <td><c:out value="${class.classPlace}" /></td>
                            <td>
                                <form action="root/deleteOrder" method="post" style="display:inline;">
                                    <input type="hidden" name="classId" value="${class.classId}">
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

    <!-- 修改密码模态框 -->
    <div id="changePasswordModal" class="modal fade" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="root/changePassword" method="post">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">修改密码</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="oldPassword">原密码:</label>
                            <input type="password" class="form-control" id="oldPassword" name="oldPassword" required>
                        </div>
                        <div class="form-group">
                            <label for="newPassword">新密码:</label>
                            <input type="password" class="form-control" id="newPassword" name="newPassword" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">提交</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

<%--    <%@ include file="footer.jsp" %>--%>

</div>
</body>
</html>
