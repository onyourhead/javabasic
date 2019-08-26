package edu.ncut.zzq.concurrent;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: PrintABCByTurns
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/7/22 15:56
 * @Version: 1.0
 */
public class PrintABCByTurns {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    @Test
    public void main() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        PrintWord printWord1 = new PrintWord("A", true);
        PrintWord printWord2 = new PrintWord("B", false);
        PrintWord printWord3 = new PrintWord("C", false);
        printWord1.setNext(printWord2);
        printWord2.setNext(printWord3);
        printWord3.setNext(printWord1);

        executorService.execute(printWord1);
        executorService.execute(printWord2);
        executorService.execute(printWord3);
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

            for (int i = 0; i < 5; i++) {
                try {
                    lock.lock();
                    while (!isOkToRun)
                        condition.wait();
                    System.out.println(word);
                    isOkToRun = false;
                    next.setOkToRun(true);
                    condition.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    }
}
