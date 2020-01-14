package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
* Cookie快速入门
* */
@WebServlet("/CookieDem4")
public class CookieDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie c1=new Cookie("msg","setMaxAge你好啊");
        //2.设置cookie的存活时间
       // c1.setMaxAge(30);//将cookie持久化到硬盘，30秒后自动删除cookie
      //  c1.setMaxAge(-1);//默认值，浏览器关闭则cookie的值自动销毁
       // c1.setMaxAge(300);
        c1.setMaxAge(0);//删除cookie的信息
        //3.发送Cookie
        resp.addCookie(c1);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
