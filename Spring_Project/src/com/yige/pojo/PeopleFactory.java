package com.yige.pojo;

import com.yige.pojo.People;

public class PeopleFactory {
    //实例工厂
//    public People newInstance(){
//        return new People(1,"测试");
//    }

    //静态工厂
    public static People newInstance(){
        return new People(1,"测试");
    }
}
