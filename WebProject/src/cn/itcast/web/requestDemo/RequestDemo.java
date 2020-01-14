package cn.itcast.web.requestDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*                 1.获取请求消息数据
                      1.获取请求行数据
                            *格式    GET/study/demo.do?name=ntt? HTTP/1.1
                            *方法
                                    1.获取请求方式 ： GET
                                        * String getMethod()
                                    2.(*)获取虚拟目录: /study
                                        *String getContextPath()
                                    3.获取Servlet路径：/demo.do
                                        *String getServletPath()
                                    4.获取get方式请求参数：name=ntt
                                        *String getQueryString()
                                    5.(*)获取请求的URI:/study/demo.do
                                        *String getRequestURI(): /study/demo.do
                                        *StringBuffer getRequestURL(): http://localhost/study/demo.do
                                    6.获取协议及版本： HTTP/1.1
                                        *String getProtocol()
                                    7.获取客户机的IP地址
                                        *String getRemoteAddr()
*
* */
@WebServlet("/RequestDemo")
public class RequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
//        1.获取请求方式 ： GET
                 String method=req.getMethod();
        System.out.println(1+method);
//        2.(*)获取虚拟目录: /study
                String ContextPath=req.getContextPath();
        System.out.println("虚拟目录"+ContextPath);

//        3.获取Servlet路径：/demo.do
                String ServletPath=req.getServletPath();
        System.out.println(3+ServletPath);
//        4.获取get方式请求参数：name=ntt
                String QueryString=req.getQueryString();
        System.out.println(4+QueryString);
//        5.(*)获取请求的URI:/study/demo.do
        String RequestURI=req.getRequestURI();
        StringBuffer RequestURL=req.getRequestURL();
        System.out.println(5+RequestURI);
        System.out.println(RequestURL);
//        6.获取协议及版本： HTTP/1.1
                String Protocol=req.getProtocol();
        System.out.println(7+Protocol);
//        7.获取客户机的IP地址
                String RemoteAddr=req.getRemoteAddr();
        System.out.println(RemoteAddr);
    }
}
