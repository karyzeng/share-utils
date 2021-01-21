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
                String threadLocalStr = threadLocal.get();
                System.out.println(Thread.currentThread().getName() + "的threadLocal值为：" + threadLocalStr);
                if (threadLocalStr == null) {
                    threadLocal.set("threadLocalStr-" + UUID.randomUUID().toString());
                }
                threadLocal.remove();
            });
        }

        threadPool.shutdown();

    }

}
