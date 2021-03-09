package com.zzp.concurrent.design.pattern;

import com.threadpool.ThreadPoolUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description 多线程版本if（不需要等待条件完成）
 * @Author karyzeng
 * @since 2021.03.09
 **/
public class BalkingAutoSaveEditor {

    private boolean changed = false;

    ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor();

    void change() {
        changed = true;
        System.out.println(String.format("%s-修改了内容", Thread.currentThread().getName()));
    }

    void autoSave() {
        if (!changed) {
            System.out.println(String.format("%s-判断到并无修改内容", Thread.currentThread().getName()));
            return;
        }

        changed = false;

        System.out.println(String.format("%s-保存修改了的内容", Thread.currentThread().getName()));
    }

    void startAutoSave() {
        es.scheduleWithFixedDelay(() -> {
            this.autoSave();
        }, 1, 5, TimeUnit.SECONDS);
    }

    static class Test {

        public static void main(String[] args) throws InterruptedException {
            BalkingAutoSaveEditor autoSaveEditor = new BalkingAutoSaveEditor();
            autoSaveEditor.startAutoSave();
            ExecutorService es = ThreadPoolUtils.newThreadPoolExecutor("修改线程");// 用来执行修改任务的线程

            Thread.sleep(2000);

            es.execute(() -> {
                autoSaveEditor.change();
            });
        }

    }

}
