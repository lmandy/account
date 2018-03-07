<%--
  Created by IntelliJ IDEA.
  User: 94993
  Date: 2017/2/26
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="basePath.jsp"%>
<html>
<head>
    <title>后台系统首页</title>
    <link href="<%=basePath%>css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div id="login">
        <c:if test="${not empty error}">
            <h4 align="center" style="color: #fff;text-shadow: 0 0 10px;">${error}</h4>
        </c:if>
        <h1>Login</h1>
        <form method="post" action="<%=basePath%>login">
            <input type="text" required="required" placeholder="用户名" name="userName">
            <input type="password" required="required" placeholder="密码" name="passWord">
            <button class="but" type="submit">登录</button>
        </form>
    </div>
</body>
</html>
