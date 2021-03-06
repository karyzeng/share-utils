package com.zzp.lock.test;

import java.math.BigDecimal;

/**
 * @Description 粗粒度锁保护没有关联关系的资源
 * @Author Garyzeng
 * @since 2019.09.30
 **/
public class CrudeLockAccount {

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 密码
     */
    private String password;

    private CrudeLockAccount() {

    }

    public CrudeLockAccount(BigDecimal balance, String password) {
        this.balance = balance;
        this.password = password;
    }

    /**
     * 取款操作
     * @param withDrawMoney
     * @return 取出的金额
     */
    public synchronized BigDecimal withDraw(BigDecimal withDrawMoney) {
        if (balance.compareTo(withDrawMoney) > 0) {
            // balance大于withDrawMoney
            balance = balance.subtract(withDrawMoney);
            return withDrawMoney;
        }
        return null;
    }

    /**
     * 存款操作
     * @param depositMoney
     * @return 存款后的余额
     */
    public synchronized BigDecimal deposit(BigDecimal depositMoney) {
        balance = balance.add(depositMoney);
        return balance;
    }

    /**
     * 修改密码
     * @param newPwd
     */
    public synchronized void modifyPwd(String newPwd){
        password = newPwd;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

}
