package edu.ncut.zzq.pattern;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: Singleton
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/7/23 14:55
 * @Version: 1.0
 */
public class Singleton {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        System.out.println(getInstance());
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> System.out.println(getInstance()));
        }
        executorService.shutdown();
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return inner.singleton;
    }

    //内部静态类
    private static class inner {
        private static Singleton singleton = new Singleton();
    }
}

