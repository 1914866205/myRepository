<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/1
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<%
    List list=new ArrayList();
    list.add(new User("张三","23"));
    list.add(new User("李四","53"));
    list.add(new User("王五","83"));
    request.setAttribute("list",list);
%>
<table border="1" width="500" align="center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    <%--数据行
        偶数行红色。奇数行绿色
    --%>

    <c:forEach items="${list}" var="user" varStatus="s">
        <c:if test="${s.count%2==0}">
            <tr bgcolor="red">
                <td>${s.count}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </c:if>

        <c:if test="${s.count%2!=0}">
            <tr bgcolor="green">
                <td>${s.count}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
            </tr>
        </c:if>

    </c:forEach>
</table>
</body>
</html>
