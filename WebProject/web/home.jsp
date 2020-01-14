<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/30
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //1.获取所有Cookie
    Cookie [] cookies=request.getCookies();
    boolean flag=false;//没有cookie为lastTime
    //2.遍历cookie数组
    if (cookies!=null&&cookies.length>0){
        for (Cookie cookie:cookies){
            //3.获取cookie的名称
            String name=cookie.getName();
            //4.判断名称是否是：lastTime
            if("lastTime".equals(name)){
                flag=true;
                //有该Cookie,不是第一次访问
                %>
                <h1>欢迎回来，您上次访问时间为:<%=URLDecoder.decode(cookie.getValue(),"utf-8")%></h1>

                <%//设置cookie的value
                //获取当前时间的字符串，重新设置cookie的值，重新发送cookie
                Date date=new Date();//                                         这里的空格会报错，应该用url编码
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                //解析时间格式
                String str_date=sdf.format(date);
                System.out.println("编码前："+str_date);
                //URL编码
                str_date= URLEncoder.encode(str_date,"utf-8");
                System.out.println("编码后："+str_date);

                cookie.setValue(str_date);
                //设置cookie的存活时间  一个月
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(cookie);
                //响应数据
                //获取Cookie的value数据
                String value=cookie.getValue();
                System.out.println("解码前："+value);
                //URL解码
                value= URLDecoder.decode(value,"utf-8");
                System.out.println("解码后："+value);
                break;
            }
        }
    }
    if (cookies==null||cookies.length==0||flag==false){
        //没有，第一次访问
        //设置cookie的value
        //获取当前时间的字符串，重新设置cookie的值，重新发送cookie
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //解析时间格式
        String str_date=sdf.format(date);
        System.out.println("编码前"+str_date);
        str_date=URLEncoder.encode(str_date,"utf-8");//URL编码
        System.out.println("编码后"+str_date);

        Cookie cookie=new Cookie("lastTime",str_date);
        //  cookie.setValue(str_date);
        //   URLDecoder.decode(str_date,"utf-8");//URL解码
        //设置cookie的存活时间  一个月
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
        %>
        <h1>欢迎您首次登陆</h1>
<%
    }
%>
</body>
</html>
