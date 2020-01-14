package com.yige.pojo.demo;

import com.yige.pojo.People;
import com.yige.pojo.demo.A;
import com.yige.pojo.demo.B;

public class PeopleFactory {
    public People createPeople(String witch){
        switch (witch){
            case "A":
                return new A();
            case "b":
                return new B();
            default:
                return null;

        }
    }
    public People createPeople(){
        return new A();
    }
}
