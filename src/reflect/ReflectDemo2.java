package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        //1.获取Person的Class对象
        Class personClass = Person.class;

        /*2.获取构造方法们
        *       Constructor<?>[]  getConStructors()                     获取所有public 修饰的构造方法
        *       Constructor<T> getDeclaredConstructor(类<?>...parameterTypes) 获取指定public 修饰的构造方法

        *       Constructor<T> getDeclaredConstructor(类<?>...parameterTypes)  获取所有构造方法，不考虑修饰符
        *       Constructor<?> [] getDeclaredConstructors()                  获取指定构造方法，不考虑修饰符

         */

        //Constructor<T> getDeclaredConstructor(类<?>...parameterTypes)   可以传多个值
        //获取指定public修饰的构造器
        Constructor constructor=personClass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        //创建带参对象
        Object person=constructor.newInstance("倪涛涛",23);
        System.out.println(person);

        Constructor constructor1=personClass.getConstructor();
        System.out.println(constructor1);
        //创建无参对象
        Object person2=constructor1.newInstance();
        System.out.println(person2);

        //空参创建无参对象的简化方法
        Object o=personClass.newInstance();
        System.out.println(o);
        //暴力反射
        //constructor.setAccessible(true);
    }

}
