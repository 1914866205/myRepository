package functionalinterface;

import java.security.PrivilegedAction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        FunctionInterfaceTest functionInterfaceTest= food -> {
            System.out.println("我爱吃" + food);
        };
        functionInterfaceTest.eat("六食堂黄焖鸡");

        Consumer consumer= o -> System.out.println("接收Object对象但不返回值");
        consumer.accept(consumer);

        Predicate predicate= o -> true;
        boolean flag=predicate.test(predicate);
        System.out.println(flag==true?true:false);

        PrivilegedAction privilegedAction= () -> 100;
        int i = (int) privilegedAction.run();
        System.out.println(i);

        String s="ad js mm qi aaa abs adas asasa mka";

        PrivilegedAction privilegedAction1= () -> {
            String str=s;
            //把所有单词按照空格分隔成一个数组
            String [] arr=str.split(" ");
            //把单词按照长度排序
            for (int j = 0; j <arr.length-1 ; j++) {
                for (int k = 0; k < arr.length-1; k++) {
                    if (arr[k].length()<arr[k+1].length()){
                        String temp=arr[k+1];
                        arr[k+1]=arr[k];
                        arr[k]=temp;
                    }
                }
            }
            for (int j = 0; j <arr.length ; j++) {
                System.out.println(arr[j]);
                if (j==4){
                    break;
                }
            }
            return null;
        };

        Consumer consumer1= o -> {
                  String str= (String) o;
                  //把所有单词按照空格分隔成一个数组
                  String [] arr=str.split(" ");
                  //把单词按照长度排序
            for (int j = 0; j <arr.length-1 ; j++) {
                for (int k = 0; k < arr.length-1; k++) {
                    if (arr[k].length()<arr[k+1].length()){
                        String temp=arr[k+1];
                        arr[k+1]=arr[k];
                        arr[k]=temp;
                    }
                }
            }
            for (int j = 0; j <arr.length ; j++) {
                System.out.println(arr[j]);
                if (j==4){
                    break;
                }
            }
        };
        consumer1.accept("ad js mm qi aaa abs adas asasa mka");
    }
}
