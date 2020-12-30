package com.zzp.thread.test;

/**
 * @Description 测试Java内存模型的线程start规则
 * @Author karyzeng
 * @since 2019.09.29
 **/
public class ThreadStartTest {

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
                System.out.println("num的值为：" + threadJoinTest.getNum());
            }
        });

        threadJoinTest.setNum(100);
        threadA.start();
    }

}
