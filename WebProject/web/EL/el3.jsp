<%@ page import="cn.itcast.domain.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/30
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式获取数据</title>
</head>
<body>
    <%
        User user=new User();
        user.setUsername("张三");
        user.setBirthday(new Date());
        request.setAttribute("u",user);

        List list=new ArrayList();
        list.add("aaa");
        list.add("bbb");
        request.setAttribute("list",list);

        Map map=new HashMap();
        map.put("sname","李四");
        map.put("gender","男");
        map.put("user",user);
        request.setAttribute("map",map);
    %>
</body>
<h3>el获取对象中的值</h3>
${requestScope.u}<!--返回的是对象的toString-->

<%--    *通过的是对象的属性来获取--%>
<%--        *  setter或getter方法，去掉set或get，将剩余部分，首字母变为小写，得到的就是属性--%>
<%--           serName-->Name-->name--%>

${requestScope.u.username}<br>
${requestScope.u.birthday}<br>
${u.birthday.month}<br>
${u.birStr}

<h3>el获取list的值</h3>
${list}<br>
${list[0]}<br>
${list[1]}<br>
<%--越界，但不会报错，不显示--%>
${list[2]}<br>

<h3>el获取map的值</h3>
${map.gender}<br>
${map["gender"]}<br>
${map.user.name}<br>
</html>
