package design_pattern.decorator.milk;

public class Main {
    public static void main(String[] args) {
        Milk milk=new PureMilk();
        milk.buy();

        milk=new HotMilk(new UnPureMilk());
        milk.buy();

        milk=new IceMilk(new PureMilk());
        milk.buy();
    }
}
