package design_pattern.decorator.milk;

public class IceMilk extends MilkDecorator {
    public IceMilk(Milk milk) {
        super(milk);
    }

    @Override
    public void buy() {
        System.out.println(milk+"加冰");
    }
}
