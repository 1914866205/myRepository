package test;

public class ThreadTest extends Thread {

    public void run() {
        try {
            for (int i = 1; ; i++) {
                Thread.sleep(1000);//毫秒
                System.out.println(i + "***继承Thread类***" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
