package com.deadlock.util.test;

import com.deadlock.util.Account;

/**
 * @Description 死锁测试类
 * @Author karyzeng
 * @since 2019.06.05
 **/
public class DeadlockTest {

    public static void main(String[] args) {
        final Account accountA = new Account(200);
        final Account accountB = new Account(300);

        Thread threadA = new Thread(() -> accountA.transfer(accountB, 50));
        threadA.setName("test-thread-A");

        Thread threadB = new Thread(() -> accountB.transfer(accountA, 250));
        threadB.setName("test-thread-B");

        threadA.start();
        threadB.start();
        try {
            threadA.join();
            threadB.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("accountA余额：" + accountA.getBalance());
        System.out.println("accountB余额：" + accountB.getBalance());

        System.out.println("结束");

    }

}
