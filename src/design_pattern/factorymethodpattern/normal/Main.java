package design_pattern.factorymethodpattern.normal;

import java.util.Scanner;

/**
 * 实现一个计算器控制台程序
 * 要求：
 * 用面向对象语言
 * 输入两个数和运算符号
 * 打印结果
 */
//ps 文件系统目录结构的好处之一：支持文件不同层级目录下重名
public class Main {
    public static void main(String[] args) throws Exception {
//  while (true) {
//      Scanner sc = new Scanner(System.in);
//      System.out.println("请输入数字A：");
//        /*
//        *
//        * double是基本数据类型，Double是原始数据类型
//          double没有方法，Double有自己的属性和方法
//          double只创建引用，Double创建对象
//          集合类不能存放double，只能存放Double
//          double存放在栈中，Double存放在堆中
//         * */
//      double strNumberA = sc.nextDouble();
//      //ps 这里为什么要新建一个Scanner?
//      //有个坑
//      //关于Scanner的连续使用，
//      // 可多个int复用一个Scanner对象
//      // 可多个String复用一个Scanner对象
//      // 可先String后int顺序复用一个Scanner对象
//      // 但不可先int后String顺序复用一个Scanner对象
//      // 会发现String输入为空   Why?
//      //      因为int输入完毕按回车提交，回车键会被当做String的输入
//      //所以这种顺序需要新建一个Scanner
//      System.out.println("请选择运算符号(+ - * /)");
//        String strOperate = sc.nextLine();
//
////      Scanner sc2 = new Scanner(System.in);
////      String strOperate = sc2.nextLine();
//
//      System.out.println("请输入数字B：");
//      double strNumberB = sc.nextDouble();
//
//      double result = 0;
//      //不忘 break  case穿透
//      switch (strOperate) {
//          case "+": {
//              result = strNumberA + strNumberB;
//              break;
//          }
//          case "-": {
//              result = strNumberA - strNumberB;
//              break;
//          }
//          case "*": {
//              result = strNumberA * strNumberB;
//              break;
//          }
//          case "/": {
//              if (strNumberB == 0) {
//                  throw new Exception("被除数不能为0");
//              }
//              /*
//               * ps    if括号的坑
//               *       if有括号作用范围:括号内
//               *       if无括号作用范围:仅下面第一行受影响
//               * */
//              result = strNumberA / strNumberB;
//              break;
//          }
//          default: {
//              System.out.println("错误输入");
//          }
//      }
//      System.out.println("结果是：" + result);
//  }
  /*
  * 缺点：每次修改都有
  *
  * */






////        ps 关于计算的其他坑

//        System.out.println("a"+1+5);
//        System.out.println(1+5+"a");

        short a=1;
//        a=a+1;
//        a++;
//        a=(short)(a+1);
//        System.out.println(a);
//        ++a;
//        System.out.println(a);

//        System.out.println(a++);1   2
//        System.out.println(++a);2   2
        short b=1;
        System.out.println(b+++a);
//        System.out.println(a);
//        System.out.println(b);
        System.out.println(b++ +a);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(b+ ++a);
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(b+a++);
//        System.out.println(a);

    }
}
