package annotation;

import java.util.Date;

/**
 *  * JDK中预定义注解
 *                 * @Override:用来检测被该注解标注的方法是否是继承父类或者父接口
 *                 * @Deprecated:该注解标注的内容，表示已过时
 *                 * @SuppressWarning:压制警告
 */
public class AnnotationDemo2 {
    @Override
    public String toString() {
        return super.toString();
    }

    @Deprecated
    public void show1(){
        //有缺陷
    }
    @SuppressWarnings("all") //压制该代码的警告    若是写在类开头，则压制该类的所有警告
    public void show2(){
        //替代show1方法
    }

    @MyAnnotation(show = "1", value =0 , per =Persona.p1 )
    public void demo(){
        show1();
        Date date=new Date();
        date.getDate();
    }



}
