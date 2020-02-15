package design_pattern.decorator.vision3;

public class Suit extends Finery {
    @Override
    public void Show() {
        System.out.print("西装");
        super.Show();
    }
}
