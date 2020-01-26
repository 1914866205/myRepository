package test;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerUtil {
    public static void main(String[] args) {
        timer1();
        timer2();
        timer3();
    }
    /**
     * 设定2000毫秒后执行
     */
    public static void timer1(){
        Timer ntimer=new Timer();
        ntimer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("闹钟1响");
            }
        },2000);
    }

    /**
     * 延迟5000毫秒，每1000毫秒执行一次
     */
public static void timer2(){
    Timer timer=new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            System.out.println("闹钟2响");
        }
    },5000,1000);
}
    /**
     * 设置13:42执行任务
     */
    public static void timer3(){
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,17);
        calendar.set(Calendar.MINUTE,26);
        calendar.set(Calendar.SECOND,0);
        Date time=calendar.getTime();
        Timer timer3=new Timer();
        timer3.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("闹钟3响");
            }
        },time,1000*60*60*24);//这里设定将延时每天固定执行
    }
}
