package reflect;

import java.lang.reflect.Field;

public class ReflectDemo1 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //1.获取Person的Class对象
        Class personClass=Person.class;

        /*
        *1.获取成员变量们
        *       Field[]  getFields()     获取所有public 修饰的成员变量
        *       Field    getField(String name)   获取指定名称的public 修饰的成员变量
        *       Field[]  getDeclaredFields()    获取所有的成员变量 不考虑修饰符
        *       Field    getDeclareField(String name)   获取指定的成员变量  不考虑修饰符
        * */

        //1.Field []   getFields()
        Field[]fields=personClass.getFields();
        for (Field field:fields){
            System.out.println(field);
        }
        System.out.println("----------------------");

        //获取指定名称的public 修饰的成员变量
        Field a=personClass.getField("a");
        //获取成员变量a的值
        Person p=new Person();
        Object value=a.get(p);
        System.out.println(value);
        //设置a的值
        a.set(p,"张三");
        System.out.println(p);

        //Field [] getDeclaredFields[]    获取所有的成员变量，不考虑修饰符
        Field[] declaredFields=personClass.getDeclaredFields();
        for (Field declaredfield : declaredFields) {
            System.out.println(declaredfield);
        }
        //Field getDeclaredField(String name)访问指定想成员变量，不考虑修饰符
        Field d=personClass.getDeclaredField("d");
        //忽略访问权限的修饰符的安全检查
        d.setAccessible(true);//暴力反射
        Object value2=d.get(p);
        System.out.println(value2);
    }
}
