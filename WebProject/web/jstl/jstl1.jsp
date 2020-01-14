<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/30
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
    c:if标签
        1.属性：
            * test必须属性，接收boolean表达式
                *如果表达式为true，则显示if标签体内容
                 如果为false，则不显示标签体内容
        注意：<c:if> 标签没有else情况
                想要else情况，则可以再定义一个<c:if>语句

    --%>
    <c:if test="true">
        <h1>我是真</h1>
    </c:if>

    <c:if test="false">
        <h1>我是假</h1>
    </c:if>

    <%
        //判断request域中的一个list集合是否为空，如果不为null，则显示遍历集合
        List list=new ArrayList();
        list.add("aaaa");
        request.setAttribute("list",list);
        request.setAttribute("number",3);
    %>

    <c:if test="${not empty list}">
        如果集合不空，则进入if语句
    </c:if>

    <c:if test="${requestScope.number%2!=0}">
        ${requestScope.number}为奇数
    </c:if>

    <c:if test="${requestScope.number%2==0}">
        ${requestScope.number}为偶数
    </c:if>
</body>
</html>
