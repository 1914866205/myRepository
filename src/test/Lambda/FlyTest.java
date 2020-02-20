package test.Lambda;


public class FlyTest {
    public static void main(String[] args) {
        Fly fly=() -> System.out.println("不会飞");
        Fly2 fly2=(String type) -> System.out.println(type);
//        Fly fly1=(speed,type)->{
//            System.out.println("用"+type+"速度"+type);
//        };
//        fly1.fly("快","头");
    }
}
