package com.zzp.concurrent.design.pattern;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description 生产者-消费者模式（分段消费案例）
 * @Author Garyzeng
 * @since 2021.03.07
 **/
public class ProducerConsumerSubsectionConsume {

    private BlockingQueue<LogMsg> logQueue = new LinkedBlockingQueue<LogMsg>(500);

    private List<LogMsg> mockFileCache = new ArrayList<LogMsg>();

    private ExecutorService consumerEs = Executors.newFixedThreadPool(1);

    private ExecutorService producerEs = Executors.newFixedThreadPool(3);

    public void consume() {
            consumerEs.execute(() -> {
                int cacheLogs = 0;// 缓存的日志，表示未刷盘的日志数量
                long startTime = System.currentTimeMillis();
                while (true) {
                    try {
                        LogMsg logMsg = logQueue.poll(5, TimeUnit.SECONDS);
                        if (logMsg != null) {
                            mockFileCache.add(logMsg);
                            ++cacheLogs;
                        }

                        // 根据刷盘规则刷盘
                        if ("ERROR".equals(logMsg.getLevel()) // 根据优先级
                                || cacheLogs == 6 // 根据空间
                                || System.currentTimeMillis() - startTime > 1000 // 根据时间
                        ) {
                            this.executeLogs(mockFileCache);
                            startTime = System.currentTimeMillis();
                            cacheLogs = 0;
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
    }

    public void produce() {
        producerEs.execute(() -> {
            for (int i = 0; i < 10; i++) {
                logQueue.add(new LogMsg("INFO", String.valueOf(i + 1)));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producerEs.execute(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    Thread.sleep(500);
                    logQueue.add(new LogMsg("ERROR", String.valueOf(i + 1)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void executeLogs(List<LogMsg> logs) {
        System.out.println(String.format("%s-刷盘了：%s", Thread.currentThread().getName(), JSON.toJSONString(logs)));
        logs.clear();
    }

    static class LogMsg{
        private String level;
        private String msg;

        public LogMsg(String level, String msg) {
            this.level = level;
            this.msg = msg;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }

    public static void main(String[] args) {
        ProducerConsumerSubsectionConsume subsectionConsume = new ProducerConsumerSubsectionConsume();
        subsectionConsume.produce();
        subsectionConsume.consume();
    }

}
