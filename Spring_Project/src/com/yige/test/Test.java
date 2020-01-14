package com.yige.test;

import com.yige.pojo.People;
import com.yige.pojo.PeopleFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
    //  People peo=new People()
//        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//        People people=ac.getBean("people", People.class);
//        System.out.println(people);
        /*
        * getBean("<bean>标签id值",返回值类型);如果没有第二个参数，默认是Object
        *
        * */
        /*
        * Spring目前所管理的所有对象
        *   getBeanDefinitionNames();
        * */
//        String[]names=ac.getBeanDefinitionNames();
//        for (String string:names){
//            System.out.println(string);
//        }

//        PeopleFactory factory=new PeopleFactory();
//        factory.createPeople("A");

        /**
         * 实例工厂测试代码
         * 用Spring修改
         */
//        PeopleFactory factory=new PeopleFactory();
//        People people=factory.newInstance();
        /**
         * 实例工厂
         * */
//        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
//        People people=ac.getBean("people2",People.class);
//        System.out.println(people);

        /**
         * 静态工厂
         * */
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        People people=ac.getBean("people3",People.class);
        // People people=PeopleFactory.newInstance();
        System.out.println(people);
    }
}
