<%--
  Created by IntelliJ IDEA.
  User: 94993
  Date: 2017/3/16
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../basePath.jsp" %>
<html>
<head>
    <title>系统用户管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>bootstrap/css/bootstrap.css">
    <script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath%>bootstrap/js/bootstrap.js"></script>
</head>
<body>
        <div class="container">
            <table class="table table-striped table-bordered">
                <tr>
                    <td>ID</td>
                    <td>用户名</td>
                    <td>密码</td>
                    <td>头像</td>
                    <td>token</td>
                </tr>
                <c:forEach items="${page.results}" var="u" varStatus="vs">
                    <tr>
                        <td>${vs.index+1}</td>
                        <td>${u.userName}</td>
                        <td>${u.passWord}</td>
                        <td>${u.portrait}</td>
                        <td>${u.token}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
</body>
</html>
