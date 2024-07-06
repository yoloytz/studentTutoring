<%@ page import="com.tutoring.pojo.Student" %>
<%@ page import="com.tutoring.pojo.Teacher" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024-07-05
  Time: 17:34
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
    <title>教师视图</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header.jsp" %>
<c:set var="pageTitle" value="教师视图" />

<div class="container">
    <h1 class="text-center">教师视图</h1>
    <h2>欢迎, <c:out value="${teacher.name}" /></h2>
    <c:if test="${not empty message}">
        <div class="alert alert-success" role="alert">
                ${message}
        </div>
    </c:if>
    <button id="logoutButton" class="btn btn-danger">退出登录</button>
    <!-- 教师信息查看和修改 -->
    <div class="panel panel-default">
        <div class="panel-heading">个人信息</div>
        <div class="panel-body">
            <form action="Teacher/updateTeacherInfo" method="post" class="form-horizontal">
                <input type="hidden" name="teacherId" value="${teacher.teacherId}">
                <div class="form-group">
                    <label for="teacherName" class="col-sm-2 control-label">账号:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="teacherName" name="teacherName" value="${teacher.teacherName}" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">姓名:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" value="${teacher.name}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="age" class="col-sm-2 control-label">年龄:</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="age" name="age" value="${teacher.age}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="gender" class="col-sm-2 control-label">性别:</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="gender" name="gender">
                            <option value="男" <c:if test="${teacher.gender == '男'}">selected</c:if>>男</option>
                            <option value="女" <c:if test="${teacher.gender == '女'}">selected</c:if>>女</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="school" class="col-sm-2 control-label">学校:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="school" name="school" value="${teacher.school}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="info" class="col-sm-2 control-label">简介:</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" id="info" name="info" rows="3">${teacher.info}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="tel" class="col-sm-2 control-label">电话:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="tel" name="tel" value="${teacher.tel}">
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

    <!-- 查看当前订单并接课 -->
    <div class="panel panel-default">
        <div class="panel-heading">当前已接订单</div>
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
                <c:forEach var="classInfo" items="${currentOrders}">
                    <tr>
                        <td><c:out value="${classInfo.className}" /></td>
                        <td><c:out value="${classInfo.classInfo}" /></td>
                        <td><c:out value="${classInfo.classMode}" /></td>
                        <td><c:out value="${classInfo.state}" /></td>
                        <td><c:out value="${classInfo.classStudentId}" /></td>
                        <td><c:out value="${classInfo.classTime}" /></td>
                        <td><c:out value="${classInfo.classPlace}" /></td>
                        <td>
                            <form action="Teacher/deleteOrder" method="post" style="display:inline;">
                                <input type="hidden" name="orderId" value="${classInfo.classId}">
                                <button type="submit" class="btn btn-success">撤单</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">全部订单</div>
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
                <c:forEach var="classInfo" items="${freeOrders}">
                    <tr>
                        <td><c:out value="${classInfo.className}" /></td>
                        <td><c:out value="${classInfo.classInfo}" /></td>
                        <td><c:out value="${classInfo.classMode}" /></td>
                        <td><c:out value="${classInfo.state}" /></td>
                        <td><c:out value="${classInfo.classStudentId}" /></td>
                        <td><c:out value="${classInfo.classTime}" /></td>
                        <td><c:out value="${classInfo.classPlace}" /></td>
                        <td>
                            <form action="Teacher/getOrder" method="post" style="display:inline;">
                                <input type="hidden" name="orderId" value="${classInfo.classId}">
                                <button type="submit" class="btn btn-success">接单</button>
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
            <form id="changePasswordForm" action="Teacher/changePassword" method="post" onsubmit="return validatePassword()">
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
                    <div class="form-group">
                        <label for="confirmPassword">确认新密码:</label>
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" required>
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

<script>
    // 从服务器获取当前用户的密码，假设当前用户信息存储在session中
    const currentPassword = "<%= ((Teacher)session.getAttribute("currentTeacher")).getTeacherPassword() %>";
    function validatePassword() {
        const oldPassword = document.getElementById('oldPassword').value;
        const newPassword = document.getElementById('newPassword').value;
        const confirmPassword = document.getElementById('confirmPassword').value;
        // 检查原密码是否正确
        if (oldPassword !== currentPassword) {
            alert("原密码不正确");
            return false;
        }

        // 检查新密码和确认新密码是否匹配
        if (newPassword !== confirmPassword) {
            alert("新密码和确认新密码不匹配");
            return false;
        }
        // 密码验证通过
        return true;
    }
    // 退出登录按钮点击事件
    document.getElementById('logoutButton').addEventListener('click', function() {
        window.location.href = 'index.jsp';
    });
</script>

<%--<%@ include file="../footer.jsp" %>--%>
</body>
</html>
