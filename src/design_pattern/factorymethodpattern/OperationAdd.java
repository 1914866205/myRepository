package design_pattern.factorymethodpattern;
//加法类
public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        double result=0;
        result = getNumberA()+getNumberB();
        return result;
    }
}