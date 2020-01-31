package test.ThreadMolUse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.Callable;

public class Times implements ActionListener,Runnable {
    public final int ONE_SECOND=1000;//一秒钟更新一次
    private JLabel timeLabel=null;//在此label上显示时间由外部传入
    private Calendar calendar=null;//获取当前时间的日历类
    private DateFormat dateFormat=null;//时间格式类 用来格式化时间用
    private Timer timeTimer=null; //计时器
    private TimeZone currentTimeZone;//当前的时区

    public Times(JLabel jLabel){
        this.timeLabel=jLabel;
        //次方法返回本地时区程序运行的地方
        this.currentTimeZone=TimeZone.getDefault();
        this.dateFormat=DateFormat.getDateTimeInstance(2,2, Locale.getDefault());
        //实例化计时器对象
        this.timeTimer=new Timer(this.ONE_SECOND,this);
        //设置重复
        this.timeTimer.setRepeats(true);
        //启动定时器
        this.timeTimer.start();

    }
    public void stopTimer(){
        this.timeTimer.stop();
    }
    public void reStartTime(){
        this.timeTimer.restart();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.calendar=Calendar.getInstance(this.currentTimeZone);
        this.timeLabel.setText("当前系统时间:"+this.dateFormat.format(this.calendar.getTime()));
    }

    @Override
    public void run() {

    }
}
