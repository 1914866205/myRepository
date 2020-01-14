package cn.itcast.web.servletContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo1")
public class servletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        * ServletContext对象的获取
        *
        *   1.通过request对象获取
            request.getServletContext();
            2.通过HttpServlet获取
            this.getServletContext
            *
            *  1.获取MIME类型：
            *MIME类型：在互联网通信过程中定义的一种文件数据类型
                * 格式：   大类型/小类型  text/html     image/jpeg

               *获取: String getMimeType(String file)  //根据后缀名获取
        *
        * */
        //1.通过request对象获取
        ServletContext context1=req.getServletContext();

        //2.通过HttpServlet获取
        ServletContext context2=this.getServletContext();
        System.out.println(context1);
        System.out.println(context2);
        System.out.println(context1==context2);//true

        //3.定义文件名称
        String filename="a.jpg";
        //4.获取MIME类型
        String mimeType=context1.getMimeType(filename);
        System.out.println(mimeType);
    }

}
