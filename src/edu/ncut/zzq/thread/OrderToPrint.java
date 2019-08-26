package edu.ncut.zzq.thread;

/**
 * title: OrderToPrint
 * projectName： javabasic
 * author： 张政淇
 * date： 2019/5/29
 * time： 10:50
 */
public class OrderToPrint {
    private volatile int count = 0;
    private final Object object = new Object();

    public static void main(String[] args) {
        OrderToPrint orderToPrint = new OrderToPrint();
        Thread thread1 = new Thread(orderToPrint.new PrintThread(1, "A"));
        Thread thread2 = new Thread(orderToPrint.new PrintThread(2, "B"));
        Thread thread3 = new Thread(orderToPrint.new PrintThread(3, "C"));
        thread1.start();
        thread2.start();
        thread3.start();

    }

    class PrintThread implements Runnable {

        private int id;
        private String word;

        public PrintThread(int id, String word) {
            this.id = id;
            this.word = word;
        }

        @Override
        public void run() {
            synchronized (object) {
                while (count<16) {
                    if (count % 3 == id - 1) {
                            count++;
                            System.out.println(word);
                            object.notifyAll();
                    } else {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }
}
