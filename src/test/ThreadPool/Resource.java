package test.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Resource implements Runnable {
    private String [] imagePaths={
            "http://img1.imgtn.bdimg.com/it/u=4227090528,100128869&fm=26&gp=0.jpg",
            "http://img4.imgtn.bdimg.com/it/u=1703094090,802953328&fm=26&gp=0.jpg",
            "http://img5.imgtn.bdimg.com/it/u=1267931373,3662510004&fm=26&gp=0.jpg"
    };
    @Override
    public void run() {
        for (int i = 0; i <imagePaths.length ; i++) {
                synchronized (this){
                    FileUtil.downPicture(imagePaths[i]);
                }
        }
    }
}
