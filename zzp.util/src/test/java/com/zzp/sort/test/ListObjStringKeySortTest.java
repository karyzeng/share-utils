package com.zzp.sort.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 对象集合List排序（排序的key为String类型）
 * @Author karyzeng
 * @since 2021.07.26
 **/
public class ListObjStringKeySortTest {

    public static void main(String[] args) {
        List<TestObj> objs = new ArrayList<TestObj>();
        objs.add(new TestObj(1, "AGY01_03,AGY01_04"));
        objs.add(new TestObj(2, "AGY01_02"));
        objs.add(new TestObj(1, "AGY01_01"));
        System.out.println(objs);
        System.out.println("AGY01_01".compareTo("AGY01_02"));
        objs.sort((obj1, obj2) -> obj1.getName().compareTo(obj2.getName()));
        System.out.println(objs);

    }

}

class TestObj {
    private Integer age;

    private String name;

    public TestObj(){}

    public TestObj(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
