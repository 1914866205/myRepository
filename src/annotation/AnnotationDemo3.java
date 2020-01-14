package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *         * 元注解： 用于描述注解的注解
 *         * @Target:描述注解能够作用的位置
 *         * @Retention:描述注解能够被保留的阶段
 *         * @Documented:描述注解能够被抽取到API文档
 *         * @Inherited: 描述注解是否被子类继承
 */

@Target(value={ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})//表示该Annotation注解只能作用于类上,方法上，成员变量上
@Retention(RetentionPolicy.RUNTIME)//自己定义的注解一般为RUNTIME值
public @interface AnnotationDemo3 {

}
