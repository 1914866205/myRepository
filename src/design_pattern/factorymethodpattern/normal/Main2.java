package design_pattern.factorymethodpattern.normal;

import java.util.Scanner;

/**
 * 实现一个计算器控制台程序
 * 要求：
 * 用面向对象语言
 * 输入两个数和运算符号
 * 打印结果
 */
public class Main2 {
    public static void main(String[] args) throws Exception {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入数字A：");

            double strNumberA = sc.nextDouble();
            System.out.println("请选择运算符号(+ - * /)");

            Scanner sc2 = new Scanner(System.in);
            String strOperate = sc2.nextLine();

            System.out.println("请输入数字B：");
            double strNumberB = sc.nextDouble();

            double result = 0;
            switch (strOperate) {
                case "+": {
                    result = strNumberA + strNumberB;
                    break;
                }
                case "-": {
                    result = strNumberA - strNumberB;
                    break;
                }
                case "*": {
                    result = strNumberA * strNumberB;
                    break;
                }
                case "/": {
                    if (strNumberB == 0) {
                        throw new Exception("被除数不能为0");
                    }
                    result = strNumberA / strNumberB;
                    break;
                }
                default: {
                    System.out.println("错误输入");
                }
            }
            System.out.println("结果是：" + result);
        }
    }
}
