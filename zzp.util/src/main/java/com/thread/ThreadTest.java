package com.thread;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2019.08.23
 **/
public class ThreadTest {

    public static void main(String[] args) {
        ParentThread threadA = new SubThreadA();
        Thread thread = new Thread(threadA);
        thread.start();
    }

}
