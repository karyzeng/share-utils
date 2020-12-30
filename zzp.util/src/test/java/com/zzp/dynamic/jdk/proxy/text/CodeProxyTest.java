package com.zzp.dynamic.jdk.proxy.text;

import java.lang.reflect.Proxy;

/**
 * 代理测试类
 * @author Garyzeng
 * @since 2019.10.27
 */
public class CodeProxyTest {

    public static void main(String[] args) {
        // 让生成的代理类class文件保存到本地
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        CodeInvocationHandler invocationHandler = new CodeInvocationHandler(new CodeServiceImpl());
        CodeService codeServiceProxy = (CodeService) Proxy.newProxyInstance(CodeProxyTest.class.getClassLoader(), new Class[]{CodeService.class}, invocationHandler);
        codeServiceProxy.codeJava();
    }

}
