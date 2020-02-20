package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class TimeTest {
    public static void main(String[] args) throws ParseException {
//​ 给定一个时间字符串“2020年02月14日 00时00分00秒”，利用Calendar工具类增加一小
// 时后打印，打印结果为“2020-02-14 01:00:00"。
        //定义要转化的时间
        String time="2020年02月14日 00时00分00秒";
        //定义被转化时间的格式                        year  month day  hour  minute second
        DateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        //         按照指定格式   解析时间  用date类型接收
        Date date=format.parse(time);
        //定义日历类对时间进行操作       日历类是单例模式  初始化不能直接new  要用getInstance()
        Calendar calendar=Calendar.getInstance();
        // 给日历类设置要修改的时间
        calendar.setTime(date);
        //  日历类的时间修改   +1小时
        calendar.add(Calendar.HOUR_OF_DAY,1);
        //  定义新的转化时间的规则
        DateFormat format1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 把日历类的时间传给date
        date=calendar.getTime();
        //  利用新的规则转换date的时间并打印出来
        System.out.println(format1.format(date));

        //      创建一个当前Instant对象，将其转换为LocalDateTime对象，减少一个月后，再转换为
        //    LocalDate对象，将其按照“1970年01月01日”格式打印。
        //创建一个当前Instant对象
        Instant instant = Instant.now();
        System.out.println(instant);
        //将其转换为LocalDateTime对象，
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        //减少一个月
        localDateTime = localDateTime.minusMonths(1);
        //再转换为LocalDate对象
        LocalDate localDate = localDateTime.toLocalDate();
        DateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=format2.parse(String.valueOf(localDate));
        DateFormat format3=new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(format3.format(date1));

    }
}
