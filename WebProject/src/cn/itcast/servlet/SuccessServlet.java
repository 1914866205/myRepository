package cn.itcast.servlet;

import cn.itcast.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SuccessServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //获取request域中共享的user对象
        User user=(User) req.getAttribute("user");
        String username=user.getUsername();
    if (user!=null){
        //给页面写一句话
        //设置编码
        resp.setContentType("text/html;charset=utf-8");
        //输出
        resp.getWriter().write("登录成功，欢迎"+username);
    }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
