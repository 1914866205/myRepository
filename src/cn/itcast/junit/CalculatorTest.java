package cn.itcast.junit;



public class CalculatorTest {
    public static void main(String[] args) {
        Calculator c=new Calculator();
        int m=c.add(1,2);
        System.out.println(m);
        int n=c.sub(1,3);
        System.out.println(n);
    }
}
