package design_pattern.factorymethodpattern;
//减法类
public class OperationSub extends Operation {
    @Override
    public double getResult() {
        double result=0;
        result = getNumberA()-getNumberB();
        return result;
    }
}