package annotation;
/*
* 描述需要执行的类名和方法名
* */


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//希望可以作用在类上面
@Target({ElementType.TYPE})

//希望可以保留在RUNTIME阶段
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {
    String className();
    String methodName();
}

/*
*   public class ProImpl implements Pro{
*       public String className(){
*               return "annotation.AnnotationDemo1"
*           }
*       public String methodName(){
*                   return "show";
*           }
*   }
* */