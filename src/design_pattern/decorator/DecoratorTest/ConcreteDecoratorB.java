package design_pattern.decorator.DecoratorTest;

public class ConcreteDecoratorB extends  Decorator {
    public void Operation(){
        //首先运行原Component的Operation()
        super.Operation();
        //再执行本类的操作，相当于对原Component进行了装饰
        AddedCahavior();
        System.out.println("具体装饰对象B的操作");

    }
    //本类的独有功能，区别于ConcreteDecoratorA
    public void AddedCahavior(){
        System.out.println("B装饰对象被创建");
    }
}
