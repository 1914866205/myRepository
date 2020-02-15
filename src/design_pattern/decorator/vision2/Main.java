package design_pattern.decorator.vision2;
//客户端
public class Main {
    public static void main(String[] args) {
        Person xc=new Person("小菜");

        System.out.println("第一种装扮");

        Finery dtx=new TShirts();
        Finery kk=new BigTrouser();
        Finery pqx=new Sneakers();

        dtx.Show();
        kk.Show();
        pqx.Show();
        xc.Show();

        System.out.println("第二种装扮");

        Finery xz=new Suit();
        Finery ld=new Tie();
        Finery px=new LeatherShoes();

        xz.Show();
        ld.Show();
        px.Show();
        xc.Show();

    }
}
