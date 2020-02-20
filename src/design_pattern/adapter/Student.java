package design_pattern.adapter;

public class Student implements Animal , Person {
    @Override
    public void run() {
        System.out.println("跑步");
    }

    @Override
    public void eat() {
        System.out.println("吃牛肉小火锅");
    }

    @Override
    public void play() {
        System.out.println("玩游戏");
    }
}
