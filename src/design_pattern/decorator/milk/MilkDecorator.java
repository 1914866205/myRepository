package design_pattern.decorator.milk;

public abstract class MilkDecorator implements Milk {
    protected Milk milk;
    public MilkDecorator(Milk milk){
        this.milk=milk;
    }
    @Override
    public void buy(){
        milk.buy();
    }
}
