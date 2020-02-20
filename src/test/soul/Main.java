package test.soul;

import java.awt.*;
import java.util.Timer;

public class Main {
    public static void main(String[] args) throws Exception {
        Robot robot=new Robot();
        Timer timer=new Timer();
//        Soul soul=new Soul(robot);
        SoulKey soulKey=new SoulKey(robot);
        //在10秒后执行第一次，之后1秒执行一次
        timer.schedule(soulKey,10000L,1000L);

    }
}
