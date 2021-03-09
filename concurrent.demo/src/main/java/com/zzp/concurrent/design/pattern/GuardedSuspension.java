package com.zzp.concurrent.design.pattern;

import com.alibaba.fastjson.JSON;
import com.threadpool.ThreadPoolUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * @Description Guarded Suspension 多线程版本if（必须要等待条件完成）
 * @Author karyzeng
 * @since 2021.03.08
 **/
public class GuardedSuspension<T> {

    private T obj;

    private Lock lock = new ReentrantLock();

    private Condition done = lock.newCondition();

    private final int timeout = 1;

    private final static Map<Object, GuardedSuspension> GUARDED_SUSPENSION_MAP = new ConcurrentHashMap<>();

    public static <K> GuardedSuspension create(K key) {
        GuardedSuspension guardedSuspension = new GuardedSuspension();
        GUARDED_SUSPENSION_MAP.put(key, guardedSuspension);
        return guardedSuspension;
    }

    public static <K, T> void fireEvent(K key, T msg) {
        GuardedSuspension guardedSuspension = GUARDED_SUSPENSION_MAP.remove(key);
        if (guardedSuspension != null) {
            guardedSuspension.onChange(msg);
        }
    }

    public T get(Predicate<T> p) {
        lock.lock();
        try {
            while (!p.test(obj)) {
                done.await(timeout, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return obj;
    }

    public void onChange(T obj) {
        lock.lock();
        try {
            this.obj = obj;
            done.signalAll();
        } finally {
            lock.unlock();
        }
    }

    static class Message {
        private String msgId;
        private String data;

        public Message(String msgId, String data) {
            this.msgId = msgId;
            this.data = data;
        }

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    static class Test {

        public void sendMsg(Message msg) {
            System.out.println(String.format("%s-发送消息：%s", Thread.currentThread().getName(), JSON.toJSONString(msg)));
        }

        public void onMessage(Message msg) {
            GuardedSuspension.fireEvent(msg.getMsgId(), msg);
        }

        public static void main(String[] args) throws InterruptedException {
            Test test = new Test();
            ExecutorService es = ThreadPoolUtils.newDefaultThreadPoolExecutor();
            String msgId = "1";
            // 模拟请求
            es.execute(() -> {
                Message message = new Message(msgId, "{}");
                test.sendMsg(message);
                GuardedSuspension<Message> guardedSuspension = GuardedSuspension.create(msgId);
                Message result = guardedSuspension.get(msg -> msg != null);
                System.out.println(String.format("%s-获得返回值：%s", Thread.currentThread().getName(), JSON.toJSONString(result)));
            });

            // 休眠5秒
            Thread.sleep(5000);

            // 模拟消费
            es.execute(() -> {
                Message message = new Message(msgId, "{响应信息}");
                test.onMessage(message);
            });
        }
    }

}
