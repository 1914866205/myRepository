package design_pattern.decorator.milk;

public class IceMilk extends MilkDecorator {
    public IceMilk(Milk milk) {
        super(milk);
    }

    public void addIce(Milk milk){
        System.out.println(milk+"加冰");
    }
    @Override
    public void buy() {
        addIce(milk);
        milk.buy();
    }
}
