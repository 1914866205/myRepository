package design_pattern.factorymethodpattern;

import java.util.Scanner;
/**
 * 实现一个计算器控制台程序
 * 要求：
 * 用面向对象语言
 * 输入两个数和运算符号
 * 打印结果
 */
public class Main {
    public static void main(String[] args) throws Exception {
        while (true) {

            Operation oper = null;

            System.out.println("请选择运算符号(+ - * /)");

            Scanner sc2 = new Scanner(System.in);
            String strOperate = sc2.nextLine();

            oper = OperationFactory.createOperate(strOperate);

            Scanner sc = new Scanner(System.in);
            System.out.println("请输入数字A：");
            oper.setNumberA(sc.nextDouble());
            System.out.println("请输入数字B：");
            oper.setNumberB(sc.nextDouble());

            double result = oper.getResult();
            System.out.println("结果是：" + result);
        }

    }
}