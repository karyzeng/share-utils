package com.zzp.dynamic.jdk.proxy.text;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类InvocationHandler
 * @author Garyzeng
 * @since 2019.10.27
 */
public class CodeInvocationHandler implements InvocationHandler {

    private Object target;

    public CodeInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备编写程序");
        Object result = method.invoke(target, args);
        System.out.println("程序编写完了");
        return result;
    }
}
