package design_pattern.decorator.DecoratorTest;

import design_pattern.decorator.DecoratorTest.Component;

/**
 * 定义了一个具体的对象，也可以给这个对象添加一些职责
 */
public class ConcreteComponent extends Component {
    @Override
    public void Operation() {
        System.out.println("具体对象的操作");
    }
}
