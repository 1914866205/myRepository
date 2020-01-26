package test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CreateStudent{
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
       //1.普通创建对象
        Student student=new Student("小胖",19);
        System.out.println(student);

        //2.反射创建对象
            //2.1获取Student的Class对象
        Class StudentClass=Student.class;
            //2.2Field[]  getDeclaredFields()    获取所有的成员变量 不考虑修饰符
        Field[]fields=StudentClass.getDeclaredFields();
            Student student1=new Student();
        for (Field field:fields){
             field.setAccessible(true);//暴力反射
            if ("name".equals(field.getName())){
                    field.set(student1,"小胖胖");
                } else if ("age".equals(field.getName())) {
                    field.set(student1,199);
                }
            }
        System.out.println(student1);

        //3.1获取Student的Class对象
        Class StudentClass2=Student.class;
        //3.2获取指定构造方法，不考虑修饰符
        Constructor constructor=StudentClass2.getConstructor(String.class,int.class);
        //暴力反射
        constructor.setAccessible(true);
        //3.3创建带参对象
        Object student3=constructor.newInstance("小胖胖胖",1999);
        System.out.println(student3);

        //4.1
            Student student4=new Student("小胖胖胖胖",19999);
//            Student student5=(Student) student4.clone();
    }
}
