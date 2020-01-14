package com.yige.pojo;

import com.yige.pojo.demo.Desk;
import org.springframework.core.convert.Property;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class People {
    private int id;
    private String name;
    private Set<String> set;
    private List<String> list;
    private String[] strs;
    private Map<String,String> map;
    private Property pro;
    private Desk desk;

    public Property getPro() {
        return pro;
    }

    public void setPro(Property pro) {
        this.pro = pro;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public String[] getStrs() {
        return strs;
    }
    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", set=" + set +
                ", list=" + list +
                ", strs=" + Arrays.toString(strs) +
                ", map=" + map +
                ", pro=" + pro +
                ", desk=" + desk +
                '}';
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public People(){
        System.out.println("执行构造方法");
    }
    public People(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("执行有参构造");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }
}
