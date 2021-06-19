package com.zzp.thread.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 线程安全计数器（多线程）
 * @Author Garyzeng
 * @since 2021.06.19
 **/
public class CounterThreadSafeTest {

    private static int counter = 0;

    public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();
        CountDownLatch cdl = new CountDownLatch(10000);
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(() -> {
                try {
                    lock.lock();
                    counter++;
                } finally {
                    cdl.countDown();
                    lock.unlock();
                }
            });
            thread.start();
        }
        cdl.await();
        System.out.println("counter=" + counter);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "毫秒");

    }

}
