package cn.itcast.web.servlet3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebServlet({"/demo6","/demo7","/demo5"})
//@WebServlet("/user/demo7")
//@WebServlet("/user/*")
//@WebServlet("/*") 这种定义方式是所有的都访问不到了才访问它
@WebServlet("*.do")//必须是某某.do才可以成功，并且这里不可以加/ 否则启动报错
public class servletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo3...");
        System.out.println(req);
    }
}
