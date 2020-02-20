package test.soul;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.TimerTask;

public class Soul extends TimerTask {
    Robot robot;
    public Soul(Robot robot){
        this.robot=robot;
    }

    @Override
    public void run() {
        this.use(robot);
    }

    public void use(Robot robot){
        //大麦麦的发表情
        robot.mouseMove(306,646);
        mouse(robot);
        //大麦麦的选表情
        robot.mouseMove(336,585);
        mouse(robot);
        //大麦麦的发消息
        robot.mouseMove(727,777);
        mouse(robot);

        //我发表情
        robot.mouseMove(1051,645);
        mouse(robot);
        //我选表情
        robot.mouseMove(1075,567);
        mouse(robot);
        //我发消息
        robot.mouseMove(1469,771);
        mouse(robot);
    }
    public void mouse(Robot robot){
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(2000);//停顿2000毫秒，即2秒
    }

}
