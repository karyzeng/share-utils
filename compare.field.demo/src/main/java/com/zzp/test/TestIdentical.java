package com.zzp.test;

import com.zzp.beans.Teacher;
import com.zzp.util.CompareUtils;

import java.util.List;

/**
 * 测试相同属性方法
 * @author zzp
 * @since 2019.06.19
 */
public class TestIdentical {

    public static void main(String[] args) {
        String jsonStr = "{\"name\":\"false\",\"age\":\"true\",\"amount\":\"true\"}";
        List<String> result = CompareUtils.compareIdenticalField(Teacher.class, jsonStr);
        System.out.println(result);
    }

}
