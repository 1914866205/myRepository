package design_pattern.decorator.DecoratorTest;

public class Main {
    public static void main(String[] args) {
        ConcreteComponent c=new ConcreteComponent();
        ConcreteDecoratorA d1=new ConcreteDecoratorA();
        ConcreteDecoratorB d2=new ConcreteDecoratorB();
        /**
         * 装饰的方法是：
         *  首先用ConcreteComponent实例化对象c
         *  然后ConcreteDecoratorA的实例化对象d1来包装c
         *  然后ConcreteDecoratorB的实例化对象d2来包装d1
         *  最终执行d2的Operation()
         */
        d1.SetComponent(c);
        d2.SetComponent(d1);
        d2.Operation();
    }
}
