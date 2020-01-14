package cn.itcast.web.responseDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo4")
public class responseDemo4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取流对象之前，设置流的默认编码：ISO-8859-1
        resp.setCharacterEncoding("utf-8");
        //还得告诉浏览器，服务器发送的消息体数据的编码
   //     resp.setHeader("content-type","text/html;charset=utf-8");
     //简单形式
        resp.setContentType("text/html;charset=utf-8");

        //1.获取字符输出流
        PrintWriter pw=resp.getWriter();
        /*
         * 这个流可以不关闭，因为该流是response获取的，response消失后流会自动关闭
         * 所有用write方法可以做到不刷新也能把数据写出缓冲区
         * */
        //2.输出数据
        pw.write("<h1>hello response</h1>");
        pw.write("你好");
    }
}
