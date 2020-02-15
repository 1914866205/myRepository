package design_pattern.decorator.vision1;

public class Person {
    private String name;
    public Person(String name){
        this.name=name;
    }
    public void WearTShirts(){
        System.out.print("大T恤");
    }
    public void WearBigTrouser(){
        System.out.print("垮裤");
    }
    public void WearSneakers(){
        System.out.print("破球鞋");
    }
    public void WearSuit(){
        System.out.print("西装");
    }
    public void WearTie(){
        System.out.print("领带");
    }
    public void WearLeatherShoes(){
        System.out.print("皮鞋");
    }
    public void Show(){
        System.out.println("装扮的"+name);
    }
}
