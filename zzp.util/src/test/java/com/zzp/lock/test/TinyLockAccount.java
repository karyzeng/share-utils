package com.zzp.lock.test;

import java.math.BigDecimal;

/**
 * @Description 细粒度锁保护没有关联关系的资源
 * @Author Garyzeng
 * @since 2019.09.30
 **/
public class TinyLockAccount {

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 密码
     */
    private String password;

    /**
     * 余额锁
     */
    private final Object balLock = new Object();

    /**
     * 密码锁
     */
    private final Object pwdLock = new Object();

    private TinyLockAccount() {

    }

    public TinyLockAccount(BigDecimal balance, String password) {
        this.balance = balance;
        this.password = password;
    }

    /**
     * 取款操作
     * @param withDrawMoney
     * @return 取出的金额
     */
    public BigDecimal withDraw(BigDecimal withDrawMoney) {
        synchronized (balLock) {
            if (balance.compareTo(withDrawMoney) > 0) {
                // balance大于withDrawMoney
                balance = balance.subtract(withDrawMoney);
                return withDrawMoney;
            }
            return null;
        }
    }

    /**
     * 存款操作
     * @param depositMoney
     * @return 存款后的余额
     */
    public BigDecimal deposit(BigDecimal depositMoney) {
        synchronized (balLock) {
            balance = balance.add(depositMoney);
            return balance;
        }
    }

    /**
     * 修改密码
     * @param newPwd
     */
    public void modifyPwd(String newPwd){
        synchronized (pwdLock) {
            password = newPwd;
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

}
