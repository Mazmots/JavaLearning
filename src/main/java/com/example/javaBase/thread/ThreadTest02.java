package com.example.javaBase.thread;

public class ThreadTest02 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadYield());
        Thread t2 = new Thread(new ThreadYield());

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}


class ThreadYield implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "@" + i);
//            Thread.yield();
        }

    }
}