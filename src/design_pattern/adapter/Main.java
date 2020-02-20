package design_pattern.adapter;

public class Main {
    public static void main(String[] args) {
        Student student=new ParStudent();
        student.eat();
        student.run();
        student.play();

        ParStudent student1=new ParStudent();
        student1.worker();
        student1.eat();
        student1.run();
        student1.play();
    }
}
