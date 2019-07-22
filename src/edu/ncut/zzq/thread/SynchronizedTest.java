package edu.ncut.zzq.thread;

/**
 * title: SynchronizedTest
 * projectName： javabasic
 * author： 张政淇
 * date： 2019/5/31
 * time： 14:17
 */
public class SynchronizedTest {
    public static void main(String[] args) {
        SynchronizedTest test1=new SynchronizedTest();
        SynchronizedTest test2=new SynchronizedTest();
        test1.a();

    }
    public synchronized void a() {
        System.out.println("i am a");

    }
    public synchronized void b() {
        System.out.println("i am b");
    }
}
