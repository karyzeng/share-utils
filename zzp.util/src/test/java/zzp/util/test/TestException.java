package zzp.util.test;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常信息转换为字符串
 * 
 * @author karyzeng
 * @since 2018.11.07
 *
 */
public class TestException {

	public static void main(String[] args) {
		try {
			System.out.println(1 / 0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("异常信息：" + printStackTraceToString(e));
		}
	}
	
	/**
	 * 将异常信息转换成字符串
	 */
	public static String printStackTraceToString(Throwable t) {
		try (StringWriter sw = new StringWriter();PrintWriter pw = new PrintWriter(sw, true);) {
			t.printStackTrace(pw);
			String stackTraceString = sw.getBuffer().toString();
			return stackTraceString;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
