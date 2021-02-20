package com.CompletableFuture.test;

import com.threadpool.ThreadPoolUtils;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description CompletableFutureTest
 * @Author karyzeng
 * @since 2019.06.14
 **/
public class CompletableFutureTest {

    @Test
    public void test () {
        // 任务 1：洗水壶 -> 烧开水
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(()->{
            System.out.println("T1: 洗水壶...");
            sleep(1, TimeUnit.SECONDS);

            System.out.println("T1: 烧开水...");
            sleep(15, TimeUnit.SECONDS);
        });
        // 任务 2：洗茶壶 -> 洗茶杯 -> 拿茶叶
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(()->{
            System.out.println("T2: 洗茶壶...");
            sleep(1, TimeUnit.SECONDS);

            System.out.println("T2: 洗茶杯...");
            sleep(2, TimeUnit.SECONDS);

            System.out.println("T2: 拿茶叶...");
            sleep(1, TimeUnit.SECONDS);
            return " 龙井 ";
        });
        // 任务 3：任务 1 和任务 2 完成后执行：泡茶
        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf)->{
            System.out.println("T1: 拿到茶叶:" + tf);
            System.out.println("T1: 泡茶...");
            return " 上茶:" + tf;
        });

        // 等待任务 3 执行结果
        System.out.println(f3.join());

//        // 一次执行结果：
//        T1: 洗水壶...
//        T2: 洗茶壶...
//        T1: 烧开水...
//        T2: 洗茶杯...
//        T2: 拿茶叶...
//        T1: 拿到茶叶: 龙井
//        T1: 泡茶...
//        上茶: 龙井
    }

    private void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 链式调用无返回值
     */
    @Test
    public void testTaskChainNoReturn() {
        CompletableFuture<String> t1 = CompletableFuture.supplyAsync(() -> {
            return "任务1的返回结果";
        });

        CompletableFuture<Void> t2 = t1.thenAccept((r) -> {
            System.out.println("得到" + r + "，开始任务2");
        });

        t2.join();
    }

    /**
     * 链式调用无返回值
     */
    @Test
    public void testTaskChainReturn() {
        ExecutorService pool1 = ThreadPoolUtils.newThreadPoolExecutor("pool-1");
        ExecutorService pool2 = ThreadPoolUtils.newThreadPoolExecutor("pool-2");
        ExecutorService pool3 = ThreadPoolUtils.newThreadPoolExecutor("pool-3");
        CompletableFuture<Integer> t1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "-执行任务1");
            return "1";
        }, pool1).thenApplyAsync((r) -> {
            System.out.println(Thread.currentThread().getName() + "-拿到任务1的返回结果：" + r);
            return "2";
        }, pool2).thenApplyAsync((r) -> {
            System.out.println(Thread.currentThread().getName() + "-拿到任务2的返回结果：" + r);
            return 3;
        }, pool3);

        System.out.println(Thread.currentThread().getName() + "-最终的返回结果：" + t1.join());
    }
}
