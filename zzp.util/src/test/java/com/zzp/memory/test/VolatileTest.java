package com.zzp.memory.test;

/**
 * @Description volatile测试
 * @Author Garyzeng
 * @since 2020.06.08
 **/
public class VolatileTest {

    private int a = 0;

    private volatile int b = 0;

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        test.method1();
        test.method2();
    }

    public void method1() {
        int r2 = a;
        b = 1;
    }

    public void method2() {
        int r1 = b;
        a = 2;
    }

}
