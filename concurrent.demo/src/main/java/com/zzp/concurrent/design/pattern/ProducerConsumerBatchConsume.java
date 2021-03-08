package com.zzp.concurrent.design.pattern;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description 生产者-消费者模式（批量消费案例）
 * @Author Garyzeng
 * @since 2021.03.07
 **/
public class ProducerConsumerBatchConsume {

    private BlockingQueue<String> taskQueue = new LinkedBlockingQueue<String>(500);

    private ExecutorService consumerEs = Executors.newFixedThreadPool(2);

    private ExecutorService producerEs = Executors.newFixedThreadPool(1);

    public void consume() {
        for (int i = 0; i < 2; i++) {
            consumerEs.execute(() -> {
                while (true) {
                    try {
                        List<String> tasks = this.pollTask();
                        if (tasks != null && tasks.size() > 0) {
                            executeTasks(tasks);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void produce() {
        producerEs.execute(() -> {
            for (int i = 0; i < 10; i++) {
                String task = UUID.randomUUID().toString().replace("-" , "");
                taskQueue.add(task);
            }
        });
    }

    public List<String> pollTask() throws InterruptedException {
        List<String> tasks = new ArrayList<String>();
        // 阻塞式获取一条任务，第一条使用阻塞式为了防止调用pollTask方法的循环进入空转
        String task = taskQueue.take();
        while (task != null) {
            tasks.add(task);
            // 非阻塞式获取一条任务
            task = taskQueue.poll();
        }
        return tasks;
    }

    public void executeTasks(List<String> tasks) {
        System.out.println(String.format("%s-处理了任务：%s", Thread.currentThread().getName(), JSON.toJSONString(tasks)));
    }

    public static void main(String[] args) {
        ProducerConsumerBatchConsume batchConsume = new ProducerConsumerBatchConsume();
        batchConsume.produce();
        batchConsume.consume();
    }

}
