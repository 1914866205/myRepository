package cn.itcast.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/CheckCodeServletDemo")
public class CheckCodeServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //1.创建一个对象，在内存中画图(验证码的图片对象)
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        //2.美化图片
        //2.1填充背景色
        Graphics g = image.getGraphics();//画笔对象
        g.setColor(Color.pink);//设置画笔颜色
        g.fillRect(0, 0, width, height);
        //2.2画边框
        g.setColor(Color.blue);
        g.drawRect(0, 0, width - 1, height - 1);

        String str = "ABCDEFGHIJKLMNOPQISTUVWXYZabcdefghijklmnopqistuvwxyz0123456789";
        //生成随机角标
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= 4; i++) {
            int index = ran.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);//随机字符
            //2.3写验证码
            g.drawString(ch + "", (width / 5) * i, height / 2);
        }
        String checkCode_session = sb.toString();
        //将验证码存入session
        req.getSession().setAttribute("checkCode_session", checkCode_session);
        //2.4画干扰线
        g.setColor(Color.green);
        //随机生成坐标点
        //设置上限
        int x1 = ran.nextInt(width);
        int x2 = ran.nextInt(width);
        int y1 = ran.nextInt(height);
        int y2 = ran.nextInt(height);
        g.drawLine(x1, y1, x2, y2);

        //3.将图片输出到页面展示     后缀名主要是为了将来输出到页面或对应的文件中使用的
        ImageIO.write(image, "jpg", resp.getOutputStream());//输出流 ，输出到页面浏览器上
    }
}
