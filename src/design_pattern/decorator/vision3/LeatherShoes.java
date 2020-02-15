package design_pattern.decorator.vision3;

public class LeatherShoes extends Finery {
    @Override
    public void Show() {
        System.out.print("皮鞋");
        super.Show();
    }
}
