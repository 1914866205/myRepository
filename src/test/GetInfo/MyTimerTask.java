package test.GetInfo;

import java.util.ArrayList;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        try {
        //从网上获取数据
        GetInfoByUrl getInfoByUrl = new GetInfoByUrl();
        String result=getInfoByUrl.getInfo();
        //对数据进行封装
        ArrayList<User> users=new NeedInfo().getList(result);
        //将数据添加到本地Excel
            new WriterExcel().weiterExcel(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
