package com.thread;

/**
 * @Description 子线程A
 * @Author karyzeng
 * @since 2019.08.23
 **/
public class SubThreadA extends ParentThread{

    @Override
    public void run() {
        System.out.println("子线程启动");
    }
}
