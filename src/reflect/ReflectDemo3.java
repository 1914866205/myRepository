package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        /*
        *  *3获取成员方法们
         *       Method[] getMethod()             获取所有public 修饰的成员方法
         *       Method<T> getMethod(String name,类<?>...parameterTypes)   获取指定public修饰的成员方法

         *       Method[] getDeclaredMethods()     获取所有成员方法
         *       Method getDeclaredMethod(String name,类<?>...parameterTypes)  获取指定成员方法

         *
        * */
        //1.获取Person的Class对象
        Class personClass = Person.class;
        //获取指定名称的方法
        personClass.getClass();
        Method eat_method=personClass.getMethod("eat");
        Person p=new Person();
        //执行方法   invoke(Object obj)
        eat_method.invoke(p);

        Method eat_method2=personClass.getMethod("eat",String.class);
        //执行方法
        eat_method2.invoke(p,"饭");

        System.out.println("*****************");

        //获取所有public修饰的方法    !!! 这里也会有父类Object类的方法
        Method[]methods=personClass.getMethods();
        for(Method method:methods){
            System.out.println(method);
            //暴力反射
            method.setAccessible(true);
            //获取方法名
            String name=method.getName();
            System.out.println("方法名"+name);
        }

        //获取类名
            String className=personClass.getName();
            System.out.println("类名"+className);//全类名：  包名+类名
    }

}
