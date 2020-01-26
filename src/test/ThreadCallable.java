package test;

import java.util.concurrent.Callable;

public class ThreadCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int i = 1;
        try {
            for (; ; i++) {
                Thread.sleep(1000);//毫秒
                System.out.println(i + "***实现Callable接口***" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  i;
    }
    }
