<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/30
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%=request.getSession().getAttribute("username")%>欢迎您</h1>
</body>
</html>
