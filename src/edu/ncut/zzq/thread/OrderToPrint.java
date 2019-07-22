package edu.ncut.zzq.thread;

/**
 * title: OrderToPrint
 * projectName： javabasic
 * author： 张政淇
 * date： 2019/5/29
 * time： 10:50
 */
public class OrderToPrint {
    private volatile int count=0;
    private volatile int i=0;
    private final Object object=new Object();

    public static void main(String[] args) {
        OrderToPrint orderToPrint=new OrderToPrint();
        Thread thread1=new Thread(orderToPrint.new PrintThread(1));
        Thread thread2=new Thread(orderToPrint.new PrintThread(2));
        Thread thread3=new Thread(orderToPrint.new PrintThread(3));
        thread1.start();
        thread2.start();
        thread3.start();

    }
    class PrintThread implements Runnable {

        private int id;

        public PrintThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            synchronized (object) {
                while (i<75) {
                    if(count%3==id-1) {
                        for (int j = 0; j < 5; j++) {
                            i++;
                            System.out.println(Thread.currentThread().getName()+","+i);
                        }
                        count++;
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
