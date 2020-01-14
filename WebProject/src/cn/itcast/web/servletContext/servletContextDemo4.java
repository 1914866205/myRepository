package cn.itcast.web.servletContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/servletContextDemo4")
public class servletContextDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
         * ServletContext对象的获取
         *  1.获取MIME类型：
            2.域对象：共享数据
            3.获取文件的真实(服务器)路径
            *
         */
        //2.通过HttpServlet获取
        ServletContext context=this.getServletContext();
        //获取文件的服务器路径
        String realPath=context.getRealPath("/b.txt");// web目录下资源访问
        System.out.println(realPath);

        //2.通过HttpServlet获取
        ServletContext context2=this.getServletContext();
        //获取文件的服务器路径
        String realPath2=context.getRealPath("/WEB-INF/classes/a.txt");// src目录下资源访问
        System.out.println(realPath2);

        //2.通过HttpServlet获取
        ServletContext context3=this.getServletContext();
        //获取文件的服务器路径
        String realPath3=context.getRealPath("/WEB-INF/c.txt");// WEB-INF目录下资源访问
        System.out.println(realPath3);

        File file=new File(realPath);
    }
}
