package design_pattern.decorator.vision3;

//客户端
public class Main {
    public static void main(String[] args) {
        Person xc=new Person("小菜");

        System.out.println("第一种装扮");

        Finery pqx=new Sneakers();//破球鞋
        Finery kk=new BigTrouser();//垮裤
        Finery dtx=new TShirts();//大T恤
        //装饰过程
        pqx.Decorate(xc);
        kk.Decorate(pqx);
        dtx.Decorate(kk);
        dtx.Show();

        System.out.println("第二种装扮");

        Finery px=new LeatherShoes();
        Finery ld=new Tie();
        Finery xz=new Suit();
        //装饰过程
        px.Decorate(xc);
        ld.Decorate(px);
        xz.Decorate(ld);
        xz.Show();

    }
}
