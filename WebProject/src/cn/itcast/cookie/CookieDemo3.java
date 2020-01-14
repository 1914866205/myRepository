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
@WebServlet("/CookieDem3")
public class CookieDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie对象
        //http中如果键一样，则返回一个数组
        Cookie c1=new Cookie("msg","hello");
        Cookie c2=new Cookie("msg1","hello1");
        Cookie c3=new Cookie("msg2","hello2");
        Cookie c4=new Cookie("msg3","hello3");
        //2.发送Cookie
        resp.addCookie(c1);
        resp.addCookie(c2);
        resp.addCookie(c3);
        resp.addCookie(c4);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
