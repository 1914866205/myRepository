package design_pattern.decorator.milk;

public class PureMilk implements Milk {
    @Override
    public void buy() {
        System.out.println("纯牛奶 3元");
    }
}
