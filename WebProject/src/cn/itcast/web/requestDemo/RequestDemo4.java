package cn.itcast.web.requestDemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       //演示获取请求头数据：referer
        String referer=request.getHeader("referer");
        System.out.println(referer);
        //防盗链
        if (referer!=null){
            if (referer.contains("/study")){
                //正常访问
            //    System.out.println("播放电影。。。");
                response.setContentType("text/html;charset-utf-8");
                response.getWriter().write("播放电影...");
            }else {
                //盗链
                System.out.println("想看电影？来优酷吧！");
            }

        }
    }
    }
