package com.zzp.lock.test;

import java.math.BigDecimal;

/**
 * @Description 细粒度锁保护没有关联关系的资源测试
 * @Author Garyzeng
 * @since 2019.09.30
 **/
public class TinyLockAccountTest {

    public static void main(String[] args) {
        BigDecimal balance = new BigDecimal("100");
        TinyLockAccount account = new TinyLockAccount(balance, "123456");
        System.out.println("取款：" + account.withDraw(new BigDecimal("99.3")) + "，余额：" + account.getBalance());
    }

}
