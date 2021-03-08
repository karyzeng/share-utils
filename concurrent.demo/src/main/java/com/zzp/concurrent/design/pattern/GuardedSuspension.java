package com.zzp.concurrent.design.pattern;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;

/**
 * @Description Guarded Suspension 多线程版本if
 * @Author karyzeng
 * @since 2021.03.08
 **/
public class GuardedSuspension<T> {

    private T obj;

    private Lock lock = new ReentrantLock();

    private Condition done = lock.newCondition();

    public T get(Predicate<T> p) {
        lock.lock();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

}
