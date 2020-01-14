<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/30
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>                                                            <!--是否忽略所有的el表达式  默认是false-->
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${3>4}
<!--忽略单个el表达式-->
\${3>4}
<h3>算术运算符</h3>
${3+4}<br>
${3-4}<br>
${3 div 4}<br>
${3%4}<br>
${3 mod 4}<br>

<h3>比较运算符</h3>
${3==4}<br>
<h3>逻辑运算符</h3>
${3>4&&3<4}<br>
${3>4 and 3<4}<br>
<h4>empty运算符</h4>
<%
    String str="abc";
    String str2=null;
    String str3=null;

    request.setAttribute("str",str);
    request.setAttribute("str2",str2);
    request.setAttribute("str3",str3);

    List list=new ArrayList();
    request.setAttribute("list",list);
%>
${empty str}
${empty str2}
${not empty str2}
${empty str3}
${not empty list}



</body>
</html>
