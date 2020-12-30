package com.zzp.thread.test;

/**
 * @Description 可见性测试
 * @Author karyzeng
 * @since 2019.09.25
 **/
public class VisibilityTest {

    private long count = 0L;

    public void add(int size) {
        for (int i = 0; i < size; i++) {
            count++;
        }
    }

    public long getCount() {
        return count;
    }

    public static void main(String[] args) {

        VisibilityTest test = new VisibilityTest();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.add(100000000);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.add(100000000);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
            System.out.println("count执行完的结果：" + test.getCount());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
