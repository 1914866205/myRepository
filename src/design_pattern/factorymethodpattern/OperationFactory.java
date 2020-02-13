package design_pattern.factorymethodpattern;

public class OperationFactory {
    public static Operation createOperate(String operate) {
        Operation oper = null;
        switch (operate) {
            case "+": {
                oper = new OperationAdd();
                break;
            }
            case "-": {
                oper = new OperationSub();
                break;
            }
            case "*": {
                oper = new OperationMul();
                break;
            }
            case "/": {
                oper = new OperationDiv();
                break;
            }
            default: {
                System.out.println("错误输入");
            }
        }
            return oper;
    }
}
