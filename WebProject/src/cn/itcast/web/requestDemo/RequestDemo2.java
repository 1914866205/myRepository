package cn.itcast.web.requestDemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        /*
        *   *String getHeader(String name):通过请求头的名称获取请求头的值
         *Enumeration<String> getHeaderNames():获取所有的请求头名称
         * */
        //获取请求头的名称
        Enumeration<String> headerNames=request.getHeaderNames();
        //2.遍历
        while (headerNames.hasMoreElements()){
            String name=headerNames.nextElement();
            //根据名称获取请求头的值
            String value=request.getHeader(name);
            System.out.println(name+"---"+value);
        }
    }
}
