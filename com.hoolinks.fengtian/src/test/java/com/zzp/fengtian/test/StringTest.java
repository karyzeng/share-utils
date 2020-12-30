package com.zzp.fengtian.test;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @Description 字符串测试
 * @Author karyzeng
 * @since 2020.12.30
 **/
public class StringTest {

    @Test
    public void test() {
        String str = "未混合的维生素B2及其衍生物(不论是否溶于溶剂)(核黄素5'—磷酸钠(无检疫要求食品添加剂))";
        String expected = "未混合的维生素B2及其衍生物(不论是否溶于溶剂)(核黄素5\\'—磷酸钠(无检疫要求食品添加剂))";
        String actual = str.replaceAll("'", "\\\\'");
        assertEquals(expected, actual);
    }

}
