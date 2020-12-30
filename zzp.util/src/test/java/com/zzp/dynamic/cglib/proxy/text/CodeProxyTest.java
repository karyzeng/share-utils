package com.zzp.dynamic.cglib.proxy.text;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @Description 代理测试类
 * @Author Garyzeng
 * @since 2019.11.01
 **/
public class CodeProxyTest {

    public static void main(String[] args) {
        // 将生成的代理类存到本地
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E:\\zzp\\ideaIU-2018.3.4.win\\idea-project\\examples\\com\\cglib");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CodeService.class);
        enhancer.setCallback(new CodeMethodInterceptor());
        // 创建代理对象
        CodeService proxy= (CodeService)enhancer.create();
        proxy.codePython();
    }

}
