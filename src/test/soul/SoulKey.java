package test.soul;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.TimerTask;

public class SoulKey extends TimerTask {
    Robot robot;

    public SoulKey(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void run() {
        this.use(robot);
    }

    public void use(Robot robot) {
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_ALT);

    }
}
