package com.zzp.thread.test;

/**
 * @Description 内存模型测试线程类
 * @Author Garyzeng
 * @since 2019.09.27
 **/
public class MemoryModel {

    private int x = 12;
    private volatile boolean v = false;

    public void write() {
        x = 66;
        v = true;
        System.out.println("写变量，变量x修改为：" + x + "，变量v修改为：" + v);
    }

    public void read() {
        if (v) {
            System.out.println("读变量，变量v：" + v + "，变量x：" + x);
        }
    }

}
