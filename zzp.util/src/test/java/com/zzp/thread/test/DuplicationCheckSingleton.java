package com.zzp.thread.test;

/**
 * @Description 双重检查创建单例
 * @Author karyzeng
 * @since 2019.09.25
 **/
public class DuplicationCheckSingleton {

    private static DuplicationCheckSingleton singleton = null;

    private String name = "双重检查创建单例";

    public static DuplicationCheckSingleton getInstance() {
        if (singleton == null) {
            synchronized (DuplicationCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new DuplicationCheckSingleton();
                }
            }
        }
        return singleton;
    }

    public String getName() {
        return name;
    }
}
