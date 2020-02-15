package design_pattern.decorator.DecoratorTest;

import design_pattern.decorator.DecoratorTest.Component;

public abstract class Decorator extends Component {
    protected Component component;
    //设置Component
    public void SetComponent(Component component){
        this.component=component;
    }
    //重写Operation，实际执行的是Component的Operation()
    @Override
    public void Operation() {
        if (component!=null){
                component.Operation();
        }
    }
}
