package annotation;

@MyAnnotation(show = "1", value = 1, per =Persona.p1 )
@AnnotationDemo3//只能作用于类上
public class worker {
    //会报错，只能作用于类上
    @AnnotationDemo3   //Type
    public void show(){

    }
    //会报错，只能作用于类上
    @AnnotationDemo3    //Type
    int age=0;
}
