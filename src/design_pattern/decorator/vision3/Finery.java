package design_pattern.decorator.vision3;
//服饰类 Decorator
public class Finery extends Person{
    protected Person component;
    //打扮
    public void Decorate(Person component){
        this.component=component;
    }

    public void Show(){
        if (component!=null){
            component.Show();
        }
    }
}
