package cn.itcast.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/SessionDemo4")
public class SessionDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取session
        HttpSession session=req.getSession();
        System.out.println(session);
        //期望客户端 关闭后，session也能相同
        Cookie c=new Cookie("JSESSIONID",session.getId());
        c.setMaxAge(60*60);
        resp.addCookie(c);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
