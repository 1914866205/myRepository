package cn.itcast.web.responseDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
* 重定向
* */
@WebServlet("/responseDemo1")
public class responseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //  this.doGet(req,resp);
        System.out.println("Demo1被访问了");
        //访问/responseDemo1,会自动跳转的/responseDemo2资源
//        //1.设置状态码为302
//        resp.setStatus(302);
//        //2.设置响应头location
//        resp.setHeader("location","/study/responseDemo2");

        //动态获取虚拟目录
        String contextPath=req.getContextPath();
        //简单的重定向方法
          resp.sendRedirect(contextPath+"/responseDemo2");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
