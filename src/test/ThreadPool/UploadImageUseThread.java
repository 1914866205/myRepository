package test.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UploadImageUseThread {
    public static void main(String[] args) {
        /**
         * 创建一个可重用，固定线程的线程池
         */
        ExecutorService pool= Executors.newFixedThreadPool(3);
        for (int i = 0; i <5 ; i++) {
            //将线放入到线程池中
            pool.execute(new Resource());
        }
        /**
         * 关闭线程池
         */
        pool.shutdown();
    }
}
