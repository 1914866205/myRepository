package cn.itcast.web.requestDemo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo8")
public class RequestDemo8 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo8被访问");
          //存储数据到request域中
            req.setAttribute("msg","hello");
//        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/RequestDemo9");
//        requestDispatcher.forward(req,resp);
            req.getRequestDispatcher("/RequestDemo9").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    }
}
