package design_pattern.decorator.milk;

public class UnPureMilk implements Milk {
    @Override
    public void buy() {
        System.out.println("不纯牛奶 0.3元");
    }
}
