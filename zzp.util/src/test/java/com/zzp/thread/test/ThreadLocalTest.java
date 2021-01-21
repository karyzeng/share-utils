package com.zzp.thread.test;

import com.threadpool.ThreadPoolUtils;

import java.util.UUID;
import java.util.concurrent.ExecutorService;

/**
 * @Description ThreadLocal测试
 * @Author karyzeng
 * @since 2021.01.21
 **/
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        ExecutorService threadPool = ThreadPoolUtils.newDefaultThreadPoolExecutor();

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                threadLocal.set("threadLocalStr-" + UUID.randomUUID().toString());
                String threadLocalStr = threadLocal.get();
                System.out.println(Thread.currentThread().getName() + "的threadLocal值为：" + threadLocalStr);
                // 如果不remove的话，线程池中的线程不销毁，则gc不会回收threadLocalMap对应的map，可能会出现内存泄漏的问题
                // 优雅的使用应该是使用完之后使用remove
                threadLocal.remove();
            });
        }

        threadPool.shutdown();

    }

}
