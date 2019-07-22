package com.interview.javabasic.thread;

public class WaitSleepDemo {
    public static void main(String[] args) {
        final Object lock = new Object();
        Thread A=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock){
                    try {
                        System.out.println(Thread.currentThread().isInterrupted());
                        System.out.println("thread A get lock");
                        System.out.println(Thread.currentThread().isInterrupted());
                        Thread.sleep(20000);
                        System.out.println(Thread.currentThread().isInterrupted());
                        System.out.println("thread A do wait method");
//                        lock.wait();
                        System.out.println("thread A is done");
                        System.out.println("thread A exit");
                    } catch (InterruptedException e){
                        System.out.println(Thread.currentThread().isInterrupted());
                        e.printStackTrace();
                    }
                }
            }
        });
        A.start();
        try{
            Thread.sleep(10);
            A.interrupt();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        Thread B=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock){
                    try {
                        System.out.println("thread B get lock");
                        System.out.println("thread B is sleeping 10 ms");
                        Thread.sleep(2000);
                        A.interrupt();
//                        lock.notifyAll();
//                        Thread.yield();
//                        Thread.sleep(2000);
                        System.out.println("thread B is done");
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        B.start();

    }
}
