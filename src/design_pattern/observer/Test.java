package design_pattern.observer;

public class Test {
    public static void main(String[] args) {
        //第一步：创建一个具体的明星
        ConCreateIdol conCreateIdol=new ConCreateIdol();
        //第二步：创建三个具体的粉丝
        ConCreateFan wf = new ConCreateFan("王锋");
        ConCreateFan zl = new ConCreateFan("郑亮");
        ConCreateFan xls = new ConCreateFan("许老师");

        //第三步：添加粉丝
        conCreateIdol.addFan(wf);
        conCreateIdol.addFan(zl);
        conCreateIdol.addFan(xls);
        //第四步：发布动态
        conCreateIdol.notify("--我 卢本伟 没有开挂！！！");
    }
}
