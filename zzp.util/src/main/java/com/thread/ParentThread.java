package com.thread;

/**
 * @Description 父线程
 * @Author karyzeng
 * @since 2019.08.23
 **/
public class ParentThread implements Runnable{

    @Override
    public void run() {
        System.out.println("父线程启动");
    }
}
