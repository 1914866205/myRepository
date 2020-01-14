package reflect2;

import domen.Person;
import reflect.Student;

public class reflectDemo1 {
    /*
    *
    *  *获取Class对象的三种方式
        Source阶段         1.Class.forName("全类名")：将字节码文件加载进内存，返回Class对象
        Class类对象阶段     2.类名.class： 通过类名的属性class获取
        Runtime阶段        3.对象.getClass():getClass()方法在Object类中定义着

    * */
    public static void main(String[] args) throws Exception {
        //1. Class.forName("全类名")   即包名.类名
        Class cls1=Class.forName("domen.Person");
        System.out.println(cls1);
        //2. 类名.class
        Class cls2= Person.class;
        System.out.println(cls2);
        //3. 对象.getClass()
        Person p=new Person();
        Class cls3=p.getClass();
        System.out.println(cls3);

        //用==去比较三个对象
        System.out.println(cls1==cls2);//true
        System.out.println(cls2==cls3);//true
        System.out.println(cls1==cls3);//true

        Class cls4=Student.class;
        System.out.println(cls1==cls4);//false
    }
}
