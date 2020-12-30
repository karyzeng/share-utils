package com.zzp.dynamic.cglib.proxy.text;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description CodeMethodInterceptor
 * @Author Garyzeng
 * @since 2019.11.01
 **/
public class CodeMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("cglib代理前置操作");
        Object object = proxy.invokeSuper(obj, args);
        System.out.println("cglib代理后置操作");
        return object;
    }
}
