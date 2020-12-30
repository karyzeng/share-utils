package com.zzp.home.test;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Description 费用计算
 * @Author Garyzeng
 * @since 2020.01.09
 **/
public class CalculateExpenses {

    public static void main(String[] args) {
        // 收入
        BigDecimal price = null;// 定价
        BigDecimal guestCleanCharge = null;// 客人清洁费

        // 支出
        BigDecimal rent = null;// 房租
        BigDecimal propertyCharge = null;// 物业费
        BigDecimal waterCharge = null;// 水费单价（一方）
        BigDecimal waterNumber = null;// 水费用量（一天）
        BigDecimal electricCharge = null;// 电费单价（一度）
        BigDecimal electricNumber = null;// 电费用量（一天）
        BigDecimal platformChargePercent = null;// 平台服务费（定价的百分比）
        BigDecimal cleanCharge = null;// 额外清洁费

        //创建对象接收键盘录入的数据
        Scanner sc = new Scanner(System.in);//创建一个scanner类的对象
        System.out.print("输入定价：");
        price = sc.nextBigDecimal();

        System.out.print("输入客人清洁费：");
        guestCleanCharge = sc.nextBigDecimal();

        System.out.print("输入房租：");
        rent = sc.nextBigDecimal();

        System.out.print("输入物业费：");
        propertyCharge = sc.nextBigDecimal();

        System.out.print("输入水费单价（一方）：");
        waterCharge = sc.nextBigDecimal();

        System.out.print("输入水费用量（一天）：");
        waterNumber = sc.nextBigDecimal();

        System.out.print("输入电费单价（一度）：");
        electricCharge = sc.nextBigDecimal();

        System.out.print("输入电费用量（一天）：");
        electricNumber = sc.nextBigDecimal();

        System.out.print("输入平台服务费（定价的百分比）：");
        platformChargePercent = sc.nextBigDecimal();

        System.out.print("输入额外清洁费：");
        cleanCharge = sc.nextBigDecimal();

        // 基础支出（房租 + 物业费）
        BigDecimal baseExpenditure = rent.add(propertyCharge);

        // 一天收入
        BigDecimal dayIncome = price.add(guestCleanCharge);

        // 一天水费
        BigDecimal dayWaterCharge = waterCharge.multiply(waterNumber).setScale(2, BigDecimal.ROUND_HALF_UP);
        // 一天电费
        BigDecimal dayElectricCharge = electricCharge.multiply(electricNumber).setScale(2, BigDecimal.ROUND_HALF_UP);
        // 平台服务费
        BigDecimal platformCharge = price.multiply(platformChargePercent).setScale(2, BigDecimal.ROUND_HALF_UP);
        // 一天支出
        BigDecimal dayExpenditure = dayWaterCharge.add(dayElectricCharge).add(platformCharge).add(cleanCharge);

        for (int i = 0;i <= 30; i++) {
            BigDecimal index = new BigDecimal("" + i);
            BigDecimal income = dayIncome.multiply(index).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal expenditure = dayExpenditure.multiply(index).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal profit = income.subtract(expenditure);
            BigDecimal totalProfit = profit.subtract(baseExpenditure);
            System.out.println("一个月住了" + i + "天，收入：" + income.toString() + "，支出：" + expenditure.toString() + "，基本月支出：" + baseExpenditure.toString() + "，利润：" + totalProfit.toString());
        }

    }

}
