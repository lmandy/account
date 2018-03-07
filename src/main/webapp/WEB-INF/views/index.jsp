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

    <frameset rows="*" cols="25%,*" frameborder="0" framespacing="0">
        <frame src="<%=basePath%>nav" name="leftFrame" noresize="noresize" scrolling="no">
        <frameset cols="*" rows="15%,*">
            <frame src="<%=basePath%>top" title="topFrame" name="topFrame"/>
            <frame src="<%=basePath%>homePage" title="mainFrame" name="mainFrame"/>
        </frameset>
    </frameset>

</html>
