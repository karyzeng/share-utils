package com.zzp.exception.test;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Description 异常测试
 * @Author Garyzeng
 * @since 2020.05.24
 **/
public class ExceptionTest {

    public static void main(String[] args) {
        try {
            sum(20);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println(getStackTrace(e));
        } catch (Exception e) {
            e.printStackTrace();
            String exceptionMsg = getStackTrace(e, true);
            System.out.println("异常信息：" + exceptionMsg);
        }
    }

    private static void sum(int num) throws NullPointerException{
        int total = 0;
        for (int i = 0; i < num; i++) {
            total += total + (i + 1);
        }
        System.out.println(1 / 0);
    }

    /**
     * 获取异常的堆栈信息
     *
     * @param t
     * @return
     */
    private static String getStackTrace(Throwable t) {
        return getStackTrace(t, false);
    }

    /**
     * 获取异常的堆栈信息
     *
     * @param t
     * @return
     */
    private static String getStackTrace(Throwable t, boolean htmlType) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        String exceptionException = sw.toString();
        if (htmlType) {
            String lineSeparator = System.getProperty("line.separator");
            exceptionException = exceptionException.replaceAll(lineSeparator, "<br/>");
        }
        return exceptionException;
    }

}
