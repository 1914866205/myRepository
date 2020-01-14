<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/30
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>
</head>
<body>
<%
//在域中存储数据
    request.setAttribute("name","张三");
    session.setAttribute("age","23");
    session.setAttribute("name","李四");
%>

<h3>el获取值</h3>
${requestScope.name}
${sessionScope.age}
${sessionScope.aa}<!--不存在，则显示空字符串-->
${name}<!--因为request域比session小，会先找小的，所有会先找request里面的数据，如果找到name，就补在找了，只找一次-->
</body>
</html>
