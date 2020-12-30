package com.zzp.rewrite.test;

/**
 * @Description 测试方法重载
 * @Author Karyzeng
 * @since 2020.05.22
 **/
public class Test {

    public static void main(String[] args) {
        VipCustomer vipCustomer = new VipCustomer();
        vipCustomer.vipDiscount(new Integer(16));
    }

}
