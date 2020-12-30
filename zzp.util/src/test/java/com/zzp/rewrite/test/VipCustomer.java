package com.zzp.rewrite.test;

/**
 * @Description vip客户类
 * @Author karyzeng
 * @since 2020.05.21
 **/
public class VipCustomer extends Customer{

    @Override
    public String isVip(String customerName) {
        return "是";
    }

    public void vipDiscount(Integer vipType) {
        System.out.println("调用：vipDiscount(Integer vipType)");
    }

    public void vipDiscount(int vipType) {
        System.out.println("调用：vipDiscount(int vipType)");
    }

    public void vipDiscount(Object vipType) {
        System.out.println("调用：vipDiscount(Object vipType)");
    }


}
