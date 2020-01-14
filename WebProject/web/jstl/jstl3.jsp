<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/12/1
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach</title>

</head>
<body>
<%--
    foreach相当于java代码的for循环
        1.完成重复操作
            for(int i=0;i<10;i++){

                }
            *属性：
                begin:开始值
                end:结束值
                war:临时变量
                step:步长
                varStatus:循环状态对象
                    index:容器中元素的索引从0开始，在普通for循环中用则展示i真实的值
                    count:循环次数，从1开始
        2.遍历容器
            list<User> list;
            for(User user:list){

                }

                属性:
                    items:容器对象
                    var:容器中元素的临时变量
                varStatus:循环状态对象
                    index:容器中元素的索引从0开始，在普通for循环中用则展示i真实的值
                    count:循环次数，从1开始

--%>
<%--
     for(int i=1; i<=10; i++){
            System.out.println(i);
        }

--%>
    <c:forEach begin="1" end="10" var="i" step="1">
        ${i}<br>
    </c:forEach>


<c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
    i=${i} 索引为${s.index}是第${s.count}次循环<br>
</c:forEach>

    <hr>

<%
    List list=new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list",list);
%>
    <c:forEach items="${list}" var="str" varStatus="s">
            索引为${s.index}<br>
            循环次数为${s.count}<br>
            ${str}<br>
    </c:forEach>

</body>
</html>
