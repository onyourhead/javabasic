package edu.ncut.zzq.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: JoinTest
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/7/23 19:50
 * @Version: 1.0
 */
public class JoinTest {
    @Test
    public void main() {


//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println("start");
        new Thread(() -> {
            System.out.println("a");
            Thread n = new Thread(() -> System.out.println("c"));
            n.start();
            try {
                n.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b");
        }).start();
        System.out.println("end");
//        executorService.shutdown();
    }
}