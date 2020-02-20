package design_pattern.singleton;
//单例模式——饱汉模式
public class Singleton2 {
    //创建一个单例对象，但不实例化
    private static Singleton2 singleton=null;
    //私有化构造方法，保证只存在一个对象
    private Singleton2(){};
    //创建公有方法，调用单例对象
    //ps  因为private修饰的对象不可以直接被调用
    public static Singleton2 getInstance(){
        if (singleton==null){
            singleton=new Singleton2();
        }
        return singleton;
    }
}
