<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024-07-05
  Time: 17:16
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
    <title>用户界面</title>
</head>
<body>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../header.jsp" %>
<%--<%@ include file="header.jsp" %>--%>
<c:set var="pageTitle" value="用户视图" />

<div class="container">
    <h1 class="text-center">用户视图</h1>
    <h2>欢迎, <c:out value="${user.userName}" /></h2>

    <!-- 用户信息查看和修改 -->
    <div class="panel panel-default">
        <div class="panel-heading">个人信息</div>
        <div class="panel-body">
            <form action="Student/updateUserInfo" method="post" class="form-horizontal">
                <input type="hidden" name="studentId" value="${user.studentId}">
                <div class="form-group">
                    <label for="userName" class="col-sm-2 control-label">账号:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="userName" name="userName" value="${user.userName}" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">姓名:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" name="name" value="${user.name}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="age" class="col-sm-2 control-label">年龄:</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="age" name="age" value="${user.age}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="gender" class="col-sm-2 control-label">性别:</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="gender" name="gender">
                            <option value="男" <c:if test="${user.gender == '男'}">selected</c:if>>男</option>
                            <option value="女" <c:if test="${user.gender == '女'}">selected</c:if>>女</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="school" class="col-sm-2 control-label">学校:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="school" name="school" value="${user.school}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="info" class="col-sm-2 control-label">简介:</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" id="info" name="info" rows="3">${user.info}</textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="tel" class="col-sm-2 control-label">电话:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="tel" name="tel" value="${user.tel}">
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

    <!-- 查看全部老师信息 -->
    <div class="panel panel-default">
        <div class="panel-heading">全部老师信息</div>
        <div class="panel-body">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>性别</th>
                    <th>学校</th>
                    <th>电话</th>
                    <th>简介</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="teacher" items="${allTeachers}">
                    <tr>
                        <td><c:out value="${teacher.name}" /></td>
                        <td><c:out value="${teacher.age}" /></td>
                        <td><c:out value="${teacher.gender}" /></td>
                        <td><c:out value="${teacher.school}" /></td>
                        <td><c:out value="${teacher.tel}" /></td>
                        <td><c:out value="${teacher.info}" /></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- 提交新的订单 -->
    <div class="panel panel-default">
        <div class="panel-heading">提交新订单</div>
        <div class="panel-body">
            <form action="Student/submitOrder" method="post" class="form-horizontal">
                <input type="hidden" name="state" value="待审核">
                <input type="hidden" name="classStudentId" value="${user.studentId}">
                <div class="form-group">
                    <label for="className" class="col-sm-2 control-label">订单名:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="className" name="className" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="classInfo" class="col-sm-2 control-label">订单信息:</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" id="classInfo" name="classInfo" rows="3" required></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="classMode" class="col-sm-2 control-label">授课方式:</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="classMode" name="classMode">
                            <option value="线上">线上</option>
                            <option value="线下">线下</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="classTime" class="col-sm-2 control-label">授课时间:</label>
                    <div class="col-sm-10">
                        <input type="datetime-local" class="form-control" id="classTime" name="classTime" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="classPlace" class="col-sm-2 control-label">授课地点:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="classPlace" name="classPlace">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">提交订单</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <!-- 查看已提交的订单状态 -->
    <div class="panel panel-default">
        <div class="panel-heading">我的订单</div>
        <div class="panel-body">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>订单名</th>
                    <th>订单信息</th>
                    <th>授课方式</th>
                    <th>状态</th>
                    <th>接单老师</th>
                    <th>授课时间</th>
                    <th>授课地点</th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="classItem" items="${studentClasses}">
                    <tr>
                        <td><c:out value="${classItem.className}" /></td>
                        <td><c:out value="${classItem.classInfo}" /></td>
                        <td><c:out value="${classItem.classMode}" /></td>
                        <td><c:out value="${classItem.state}" /></td>
                        <td><c:out value="${classItem.classTeacherId}" /></td>
                        <td><c:out value="${classItem.classTime}" /></td>
                        <td><c:out value="${classItem.classPlace}" /></td>
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
            <form action="user/changePassword" method="post">
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

<%--<%@ include file="footer.jsp" %>--%>
</body>
</html>
