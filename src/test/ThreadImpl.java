package test;

/**
 * * 创建线程方式1实现
 * * 实现Runnable接口，重写run方法
 */
public class ThreadImpl implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; ; i++) {
                Thread.sleep(1000);//毫秒
                System.out.println(i + "***实现runnable接口***" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
