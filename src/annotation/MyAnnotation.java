package annotation;


public @interface MyAnnotation {
    public String show();
    public abstract int value();
    public int age ()default  0;//如果不赋值，默认为0
    Persona per();

}
