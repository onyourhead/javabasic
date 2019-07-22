package edu.ncut.zzq.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * title: VolatileTest
 * projectName： javabasic
 * author： 张政淇
 * date： 2019/5/29
 * time： 11:24
 */
public class VolatileTest {
    private int count=0;
    private final Object object=new Object();
    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest=new VolatileTest();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(volatileTest.new NumAdd());
        }
        Thread.sleep(3000);
        executorService.shutdown();
        System.out.println(volatileTest.count);

    }
    class NumAdd implements Runnable {

        @Override
        public void run() {
            synchronized (object) {
                for (int i = 0; i < 500; i++) {
                    count++;
                }
            }
        }
    }
}
