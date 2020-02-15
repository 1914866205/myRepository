package design_pattern.decorator.vision2;

public class Person {
    private String name;
    public Person(String name){
        this.name=name;
    }
    public void Show(){
        System.out.println("装扮的"+name);
    }
}
