package com.zzp.thread.test;

/**
 * @Description 测试Java内存模型的线程join规则
 * @Author karyzeng
 * @since 2019.09.26
 **/
public class ThreadJoinTest {

    private int num = 10;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public static void main(String[] args) {

        ThreadJoinTest threadJoinTest = new ThreadJoinTest();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                threadJoinTest.setNum(20);
            }
        });

        System.out.println("join之前num的值为：" + threadJoinTest.getNum());
        threadA.start();
        try {
            threadA.join();
            System.out.println("join之后num的值为：" + threadJoinTest.getNum());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
