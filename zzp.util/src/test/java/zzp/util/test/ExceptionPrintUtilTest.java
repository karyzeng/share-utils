package zzp.util.test;

import com.util.exception.ExceptionPrintUtil;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2019.06.04
 **/
public class ExceptionPrintUtilTest {

    public static void main(String[] args) {
        try {
            String str = null;
            str.contains("a");
        } catch (Exception e) {
            System.out.println("异常信息为：" + ExceptionPrintUtil.printStackTraceToString(e));
        }
    }

}
