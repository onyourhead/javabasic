package bishi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: Apple
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/8/13 20:19
 * @Version: 1.0
 */
public class Apple {
    private final Object object = new Object();
    private int num;

    public Apple(int num) {
        this.num = num;
    }


    public static void main(String[] args) {
        Apple apple = new Apple(100);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Mokey a = apple.new Mokey(false,2);
        Mokey b = apple.new Mokey(false,3);
        a.setOther(b);
        b.setOther(a);
        executorService.execute(a);
        executorService.execute(b);
        executorService.shutdown();
    }
    class Mokey implements Runnable {
        Mokey other;
        boolean flag = false;
        int eatNum;


        public Mokey(boolean flag, int eatNum) {
            this.flag = flag;
            this.eatNum = eatNum;
        }


        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public void setOther(Mokey other) {
            this.other = other;
        }

        @Override
        public void run() {
            while (num > eatNum) {
                synchronized (object) {
                    if (flag) {
                        num -= 2;
                        flag = false;
                        other.setFlag(true);
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
