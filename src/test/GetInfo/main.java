package test.GetInfo;

import java.util.Calendar;
import java.util.Timer;

public class main {
    public static boolean init=true;
    public static boolean write=true;
    public static int day=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    public static void main(String[] args) throws Exception {
        Timer timer=new Timer();
        MyTimerTask myTimerTask=new MyTimerTask();
        //在2秒后执行第一次，之后每5秒执行一次
        timer.schedule(myTimerTask,2000L,5000L);
    }
}
