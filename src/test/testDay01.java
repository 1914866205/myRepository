package test;

import java.io.*;

/*
程序随机生成100个0-99之间的随机整数存入数组，
选取一种合适的流，将该数组的100个整数写入本地文件
 */
public class testDay01 {
    public static void main(String[] args) {
        OutputStream fos=null;
        //1.动态初始化数组
        String [] arr=new String[100];
        try {
        //2.创建字符输出流，将输入写进文件
            fos= new FileOutputStream(new File("D:\\test\\100个随机数.txt"));
        //3.用for循环创建随机数，并添加到数组
        for (int i=0;i<100;i++){
            arr[i]="  "+(int)(Math.random()*100);
            fos.write(arr[i].getBytes());
            System.out.println(arr[i]);
        }
        //4.关闭流
        fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*
public class testDay01 {
    public static void main(String[] args) {
    //    FileOutputStream fos=null;
        //1.动态初始化数组
        byte [] arr=new byte[100];
        //2.用for循环创建随机数，并添加到数组
        for (int i=0;i<100;i++){
            arr[i]= (byte) (Math.random()*100);
            System.out.println(arr[i]);
        }
        try {
        //3.创建字符输出流，将输入写进文件
         //   fos= new FileOutputStream(new File("D:\\100个随机数.txt"));
            OutputStreamWriter ow=new OutputStreamWriter(new FileOutputStream(new File("D:\\100个随机数.txt")),"GBK");
            String s=new String(arr);
 //            byte[] arr2=s.getBytes("GBK");
            ow.append(s);
        //4.关闭流
        ow.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

*/