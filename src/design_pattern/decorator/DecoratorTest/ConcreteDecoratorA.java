package design_pattern.decorator.DecoratorTest;

public class ConcreteDecoratorA extends  Decorator {
    //本类的独有功能，区别于ConcreteDecoratorB
    private String addedState;
    public void Operation(){
        //首先运行原Component的Operation()
        super.Operation();
        //再执行本类的操作，相当于对原Component进行了装饰
        addedState="New State";
        System.out.println("具体装饰对象A的操作");
    }
}
