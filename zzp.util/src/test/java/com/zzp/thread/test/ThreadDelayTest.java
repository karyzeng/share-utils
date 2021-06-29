package com.zzp.thread.test;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @Description 线程延迟执行
 * @Author Garyzeng
 * @since 2021.06.29
 **/
public class ThreadDelayTest {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread myThread = new MyThread(i);
            Thread thread = new Thread(myThread);
            thread.start();
        }
    }

}

class MyThread implements Runnable{

    private int i;

    public MyThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(i * 10);
            System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
