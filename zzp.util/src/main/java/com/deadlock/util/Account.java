package com.deadlock.util;

/**
 * @Description 死锁例子Account
 * @Author karyzeng
 * @since 2019.06.05
 **/
public class Account {

    private int balance;

    public Account(){};

    public Account(int balance) {
        this.balance = balance;
    }

    // 转账
    public void transfer(Account target, int amt){
        // 锁定转出账户
        synchronized(this) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 锁定转入账户
            synchronized(target) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }

    public int getBalance() {
        return balance;
    }
}
