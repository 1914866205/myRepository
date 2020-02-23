package design_pattern.observer;

public class ConCreateFan implements Fan {
    private String name;

    public ConCreateFan(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name+"的偶像说"+message);
    }
}
