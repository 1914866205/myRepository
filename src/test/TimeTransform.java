package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTransform {
    public static void main(String[] args) throws ParseException {
        //给定一个时间，和当前时间比差多少
        // 2020年02月17 15时48分32秒
        String time="2021年02月17日 15时48分32秒";
        System.out.println(getTime(time));
    }
    public static String getTime(String time) throws ParseException {
        //设置解析格式
        DateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date oldDate=new Date();
        oldDate=format.parse(time);
        //把当前时间解析为毫秒值
        Date nowDate=new Date();
        //获取当前时间
        nowDate.getTime();
        String str=null;
        long date= (nowDate.getTime() - oldDate.getTime())/1000;
        System.out.println(date);
        if(date>=3600*24*30*12){
            str=date/3600/24/30/12+"年前";
        }else if (date>=3600*24*30){
            str=date/3600/24/30+"月前";
        }else if (date>=3600*24){
            str=date/3600/24+"天前";
        }else if (date>=3600){
            str=date/3600+"小时前";
        }else if (date>5*60){
            str=date/60+"分钟前";
        }else if (date>=0){
            str="刚刚";
        }else {
            str="瞎输什么时间";
        }
        return str;
    }
}
