package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //可以创建任意类的对象，可以执行任意方法
        /*
        * 前提：不能改变该类的任何代码，可以创建任意类的对象，可以执行任意方法
        * */
//        Person p=new Person();
//        p.eat();
        //1.加载配置文件
        //1.1 创建Propertires对象
        Properties pro=new Properties();
        //1.2 加载配置文件，转换为一个集合

        //1.2.1获取class目录下的配置文件  可以用 类加载器
        ClassLoader classLoader=ReflectTest.class.getClassLoader();
        //classLoader.getResource();//获取资源的路径
        //获取资源的字节流
        InputStream is=classLoader.getResourceAsStream("pro.properties");
        pro.load(is);
       // is.close();
        //2.获取配置文件中定义的数据
        String className=pro.getProperty("String");
        String methodName=pro.getProperty("methodName");

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
