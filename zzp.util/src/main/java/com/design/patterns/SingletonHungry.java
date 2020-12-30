package com.design.patterns;

/**
 * @Description 饿汉式单例模式
 * @Author karyzeng
 * @since 2019.09.06
 **/
public class SingletonHungry {

    private static final SingletonHungry instance = new SingletonHungry();

    private SingletonHungry() {};

    public static SingletonHungry getInstance() {
        return instance;
    }

}
