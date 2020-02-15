package design_pattern.decorator.vision1;
//用控制台的程序，写可以给人搭配嘻哈服或白领装的代码
public class Main {
    public static void main(String[] args) {
        Person xc=new Person("小菜");
        System.out.println("第一种装扮：");
        xc.WearTShirts();
        xc.WearBigTrouser();
        xc.WearSneakers();
        xc.Show();

        System.out.println("第一种装扮：");
        xc.WearSuit();
        xc.WearTie();
        xc.WearLeatherShoes();
        xc.Show();
    }
}
