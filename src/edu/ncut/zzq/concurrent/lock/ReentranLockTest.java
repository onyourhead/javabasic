package edu.ncut.zzq.concurrent.lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: ReentranLockTest
 * @Description: TODO
 * @Author: zhangzhengqi
 * @DateTime: 2019/7/23 17:31
 * @Version: 1.0
 */
public class ReentranLockTest {
    private Lock lock = new ReentrantLock();
    public void a() {
        try {
            lock.lock();
            System.out.println("a");
            b();

        } finally {
            lock.unlock();
        }

    }

    public void b() {
        try {
            lock.lock();
            System.out.println("b");

        } finally {
            lock.unlock();
        }

    }

    @Test
    public void main() {
        a();
    }
}
