package test.GetInfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;

public class main {
    public static boolean init=true;
    public static boolean write=true;
    public static int day=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
//    public static int day2=3;
    public static void main(String[] args) throws Exception {
//        GetInfoByUrl getInfoByUrl = new GetInfoByUrl();
//        String result=getInfoByUrl.getInfo();
//        //对数据进行封装
//        ArrayList<User> users=new NeedInfo().getList(result);
//        //将数据添加到本地Excel
//        new WriterExcel().weiterExcel(users);

        Timer timer=new Timer();
        MyTimerTask myTimerTask=new MyTimerTask();
        //在2秒后执行第一次，之后每天执行一次
        timer.schedule(myTimerTask,2000L,1000*60*60*24L);
    }
}
