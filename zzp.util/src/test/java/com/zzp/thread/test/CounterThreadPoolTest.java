package com.zzp.thread.test;

import com.threadpool.ThreadPoolUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 线程安全计数器（线程池）
 * @Author Garyzeng
 * @since 2021.06.19
 **/
public class CounterThreadPoolTest {

    private static int counter = 0;

    public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();
        CountDownLatch cdl = new CountDownLatch(10000);
        ExecutorService threadPool = ThreadPoolUtils.newThreadPoolExecutor(5, 10, 60 * 1000L, 10000, "Custom-Thread-Pool");
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 10000; i++) {
            threadPool.execute(() -> {
                try {
                    lock.lock();
                    counter++;
                } finally {
                    cdl.countDown();
                    lock.unlock();
                }
            });
        }
        cdl.await();
        threadPool.shutdown();
        System.out.println("counter=" + counter);
        System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + "毫秒");

    }

}
