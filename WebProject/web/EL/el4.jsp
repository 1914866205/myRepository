<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/30
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>隐式对象</title>
</head>
<body>
${pageContext.request}<br>
<h4>在jsp页面动态获取虚拟目录</h4>
${pageContext.request.contextPath}<br>
<%--
<form action="/study/loginServlet" method="get">
以下方式 完美 避开 虚拟目录发生变化 会出现的错误
--%>
<form action="${pageContext.request.contextPath/待跳转页面}" method="get">

<%
    response.sendRedirect(request.getContextPath());
%>
</body>
</html>
