package com.zzp.lock.test;

import java.math.BigDecimal;

/**
 * @Description 保护有关联关系的资源测试
 * @Author Garyzeng
 * @since 2019.09.30
 **/
public class AccountTest {

    public static void main(String[] args) {
        Account accountA = new Account();
        Account accountB = new Account();
        Account accountC = new Account();

        Thread thread1 = new Thread(() -> {
           accountA.transfer(accountB, new BigDecimal("100"));
        });

        Thread thread2 = new Thread(() -> {
            accountB.transfer(accountC, new BigDecimal("100"));
        });

        try {
            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();
            System.out.println("账户A余额：" + accountA.getBalance() + "，账户B余额：" + accountB.getBalance() + "，账户C余额：" + accountC.getBalance());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
