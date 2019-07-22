package edu.ncut.zzq.concurrent;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: PrintABCByTurns
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/7/22 15:56
 * @Version: 1.0
 */
public class PrintABCByTurns {
    @Test
    public void main() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        PrintWord printWord1 = new PrintWord("A",true);
        PrintWord printWord2 = new PrintWord("B", false);
        PrintWord printWord3 = new PrintWord("C", false);
        printWord1.setNext(printWord2);
        printWord2.setNext(printWord3);
        printWord3.setNext(printWord1);
        printWord1.setOkToRun(true);

        for (int i = 0; i < 3; i++) {
            executorService.execute(printWord1);
            executorService.execute(printWord2);
            executorService.execute(printWord3);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

    }
    class PrintWord implements Runnable {
        private String word;
        private volatile boolean isOkToRun;
        private PrintWord next;

        public PrintWord(String word, boolean isOkToRun) {
            this.word = word;
            this.isOkToRun = isOkToRun;
        }

        public void setNext(PrintWord next) {
            this.next = next;
        }

        public void setOkToRun(boolean okToRun) {
            isOkToRun = okToRun;
        }

        @Override
        public void run() {
//            synchronized (next) {
//                if(isOkToRun) {
//                    System.out.println(word);
//                    isOkToRun = false;
//                    next.setOkToRun(true);
//                    notify();
//
//                } else {
//                    try {
//                        wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }

            while (!isOkToRun) {
            }
            System.out.println(word);
            isOkToRun = false;
            next.setOkToRun(true);

        }
    }
}
