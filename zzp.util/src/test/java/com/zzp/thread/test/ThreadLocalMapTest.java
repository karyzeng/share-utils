package com.zzp.thread.test;

import com.threadpool.ThreadPoolUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * @Description ThreadLocal测试
 * @Author karyzeng
 * @since 2021.01.21
 **/
public class ThreadLocalMapTest {

    private static ThreadLocal<Map<String, String>> threadLocalMap = new ThreadLocal<Map<String, String>>();

    public static void main(String[] args) {
        ExecutorService threadPool = ThreadPoolUtils.newDefaultThreadPoolExecutor();

        for (int i = 0; i < 1; i++) {
            threadPool.execute(() -> {
                Map<String, String> testMap = new HashMap<String, String>();
                threadLocalMap.set(testMap);

                for (int j = 0; j < 5; j++) {
                    Map<String, String> map = threadLocalMap.get();
                    String key = null;
                    if (j % 2 == 0) {
                        // 偶数
                        key = "zzp2";
                    } else {
                        // 奇数
                        key = "zzp1";
                    }
                    String value = map.get(key);
                    if (value != null) {
                        // value存在
                        System.out.println(Thread.currentThread().getName() + "的threadLocalMap值存在，key：" + key + "，value：" + value);
                    } else {
                        // value不存在
                        value = "testValue";
                        map.put(key, value);
                        System.out.println(Thread.currentThread().getName() + "的threadLocalMap值不存在，key：" + key + "，value：" + value);
                    }
                }

                // 如果不remove的话，线程池中的线程不销毁，则gc不会回收threadLocalMap对应的map，可能会出现内存泄漏的问题
                // 优雅的使用应该是使用完之后使用remove
                threadLocalMap.remove();
            });
        }

        threadPool.shutdown();

    }

}
