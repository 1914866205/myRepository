package com.yige.test;

import com.yige.pojo.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        //对对象赋值
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        People people=ac.getBean("peo",People.class);
        System.out.println(people);
    }
}
