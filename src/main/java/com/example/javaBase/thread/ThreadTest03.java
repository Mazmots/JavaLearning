package com.example.javaBase.thread;

public class ThreadTest03 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadJoin());
        thread.setName("join线程");
        thread.start();

//        thread.join();

        for (int i = 0; i < 100; i++) {
            System.out.println("main@"+ i);
        }
    }
}


class ThreadJoin implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "@" + i);
        }
    }
}