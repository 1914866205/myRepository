package reflect2;

import annotation.Pro;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 框架类
 */

@Pro(className = "annotation.Demo2",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception{
        //注解大多部分都是替代配置文件的
        /*  其实就是在内存中生成了一个该注解接口的子类实现对象
         *   public class ProImpl implements Pro{
         *       public String className(){
         *               return "annotation.AnnotationDemo1"
         *           }
         *       public String methodName(){
         *                   return "show";
         *           }
         *   }
         * */
        //1. 解析注解
        //1.1 获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass=ReflectTest.class;
        //2.获取上面的注解对象
        Pro an=reflectTestClass.getAnnotation(Pro.class);//其实就是在内存中生成一个该注解接口的子类实现对象
        //3.调用注解对象中定义的抽象方法，获取返回值
        String className=an.className();
        String methodName=an.methodName();
        System.out.println("className"+className);
        System.out.println("methodName"+methodName);


        //2.获取配置文件中定义的数据
     //   String className=pro.getProperty("String");
     //   String methodName=pro.getProperty("methodName");

        //3.加载该类进内存
        Class cls=Class.forName(className);
        //4.创建对象
        Object obj=cls.newInstance();
        //5.获取方法对象
        Method method=cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);
    }

}
