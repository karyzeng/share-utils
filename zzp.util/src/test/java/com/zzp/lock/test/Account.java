package com.zzp.lock.test;

import java.math.BigDecimal;

/**
 * @Description 保护有关联关系的资源
 * @Author Garyzeng
 * @since 2019.09.30
 **/
public class Account {

    private BigDecimal balance = new BigDecimal("200");

    public void transfer(Account target, BigDecimal amt) {
        synchronized(Account.class) {
            if (this.balance.compareTo(amt) > 0) {
                this.balance = this.balance.subtract(amt);
                target.balance = target.balance.add(amt);
            }
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
