package com.example.javaBase.thread;

import java.util.concurrent.ExecutionException;

public class ThreadTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyRunnable r = new MyRunnable();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.setName("线程一");
        t2.setName("线程二");
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();


        // callable返回值
//        MyCallable myCallable = new MyCallable();
//        FutureTask<Integer> ft = new FutureTask<>(myCallable);
//        Thread thread = new Thread(ft);
//        thread.start();
//        System.out.println(ft.get());

    }
}
