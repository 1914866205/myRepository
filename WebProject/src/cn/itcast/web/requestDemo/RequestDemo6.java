package cn.itcast.web.requestDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //post获取请求参数
        //根据请求参数的名称获取参数的值
        String username=req.getParameter("username");
        System.out.println("post");
        System.out.println(username);
        //根据参数名称获取参数值的数组
        String[] hobbies=req.getParameterValues("hobby");
        for (String hobby:hobbies){
            System.out.println(hobby);
        }

        //获取所有请求的参数名称
        Enumeration<String> parameterNames=req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = req.getParameter(name);
            System.out.println(value);
            System.out.println("--------------");
        }
        //获取所有参数的map集合
        Map<String,String[]> parameterMap= (Map<String, String[]>) req.getParameterMap();
        //遍历
        Set<String> keyset=parameterMap.keySet();
        for (String name:keyset){
            //根据键获取值
            String[] values=parameterMap.get(name);
            System.out.println(name);
            for (String value:values){
                System.out.println(value);
            }
        }
        }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //get获取请求参数
        //根据请求参数的名称获取参数的值
//        String username=request.getParameter("username");
//        System.out.println("get");
//        System.out.println(username);
        this.doPost(request,response);
    }
    }
