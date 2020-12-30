package com.zzp.thread.test;

/**
 * @Description 内存模型测试类
 * @Author Garyzeng
 * @since 2019.09.27
 **/
public class MemoryModelTest {

    public static void main(String[] args) {
        MemoryModel memoryModel = new MemoryModel();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                memoryModel.write();
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                memoryModel.read();
            }
        });

        threadA.start();
        threadB.start();
    }

}
