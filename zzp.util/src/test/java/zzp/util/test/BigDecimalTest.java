package zzp.util.test;


import java.math.BigDecimal;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2019.05.27
 **/
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal bigDecimal2 = new BigDecimal("563.22");
        BigDecimal temp = bigDecimal2.remainder(new BigDecimal("1"));
        System.out.println(temp);
        if (temp.compareTo(new BigDecimal("0")) == 0){
            System.out.println("是整数");
        } else {
            System.out.println("不是整数");
        }

        Double d = 28.07899999999999997;
        BigDecimal bigDecimal = new BigDecimal(d).setScale(4, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal.doubleValue());

    }
}
