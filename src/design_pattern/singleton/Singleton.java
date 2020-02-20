package design_pattern.singleton;

public class Singleton {
    //饿汉模式
    private static Singleton singleton=new Singleton();
    private Singleton(){};
    public static Singleton getInstance(){
        return singleton;
    }
}
