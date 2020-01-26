package test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        /**
         * 创建线程方式——实现Runnable接口，重新run方法
         * 优点：方便扩展
         */
        ThreadImpl thread1=new ThreadImpl();
        new Thread(thread1).start();

        /**
         * 创建线程方式——继承Thread类，重写run方法
         */
        ThreadTest threadTest=new ThreadTest();
        threadTest.start();

        /**
         * 创建线程方式——实现Callable接口，重写call方法
         */
        int resultFromThread;
        ThreadCallable threadCallable=new ThreadCallable();
        FutureTask<Integer> futureTask=new FutureTask<>(threadCallable);
        new Thread(futureTask).start();
        Thread.sleep(5000);//这里可能做一些事情
        /**
         * 注意，这里有个问题：主线程必须等子线程执行完，才可以继续执行，变成同步
         */
        resultFromThread=futureTask.get();
    }
}
