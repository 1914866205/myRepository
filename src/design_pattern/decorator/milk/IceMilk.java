package design_pattern.decorator.milk;

public class HotMilk extends MilkDecorator {
    public HotMilk(Milk milk) {
        super(milk);
    }

    public void addHot(Milk milk){
        System.out.println(milk+"加热");
    }
    @Override
    public void buy() {
        addHot(milk);
        milk.buy();
    }
}
