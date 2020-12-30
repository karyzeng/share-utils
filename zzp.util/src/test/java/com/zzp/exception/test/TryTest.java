package com.zzp.exception.test;

/**
 * @Description try测试
 * @Author Garyzeng
 * @since 2020.06.03
 **/
public class TryTest {

    private static int tryBlock;

    private static int catchBlock;

    private static int finallyBlock;

    private static int methodExitBlock;

    public static void main(String[] args) {
        try {
            tryBlock = 1;
            System.out.println(tryBlock);
        } catch (Exception e) {
            catchBlock = 2;
            System.out.println(catchBlock);
        } finally {
            finallyBlock = 3;
            System.out.println(finallyBlock);
        }
        methodExitBlock = 4;
        System.out.println(methodExitBlock);
    }

}
