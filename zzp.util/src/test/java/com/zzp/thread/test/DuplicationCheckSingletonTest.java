package com.zzp.thread.test;

/**
 * @Description 双重检查创建单例测试类
 * @Author karyzeng
 * @since 2019.09.25
 **/
public class DuplicationCheckSingletonTest {

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " - " + DuplicationCheckSingleton.getInstance());
                System.out.println(Thread.currentThread() + " - " + DuplicationCheckSingleton.getInstance().getName());
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " - " + DuplicationCheckSingleton.getInstance());
                System.out.println(Thread.currentThread() + " - " + DuplicationCheckSingleton.getInstance().getName());
            }
        });

        threadA.start();
        threadB.start();
    }

}
