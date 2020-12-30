package zzp.util.test;

import com.util.exception.ExceptionPrintUtil;
import sun.security.action.GetPropertyAction;

import java.security.AccessController;

/**
 * @Description 异常信息解析Test
 * @Author karyzeng
 * @since 2019.07.24
 **/
public class StringTest {

    public static void main(String[] args) {
        String str = "com.baomidou.mybatisplus.extension.exceptions.ApiException: 归并失败，2，{2}项不符合相同的归并条件，请重新填写报关单商品序号\r\ncom.baomidou.mybatisplus.extension.exceptions.ApiException: 归并失败，2，{2}项不符合相同的归并条件，请重新填写报关单商品序号\r\n\tat com.hoolinks.dcl.service.impl.InvtBillProductServiceImpl.merger(InvtBillProductServiceImpl.java:195)\r\n\tat com.hoolinks.dcl.service.impl.InvtBillProductServiceImpl.create(InvtBillProductServiceImpl.java:93)\r\n\tat com.hoolinks.dcl.service.impl.InvtBillProductServiceImpl$$FastClassBySpringCGLIB$$58b1c194.invoke(<generated>)\r\n\tat org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:204)\r\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:746)\r\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\r\n\tat org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:88)\r\n\tat com.hoolinks.log.aop.BusinessLogAop.handle(BusinessLogAop.java:89)\r\n\tat com.hoolinks.log.aop.BusinessLogAop.recordSysLog(BusinessLogAop.java:54)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:644)\r\n\tat org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:633)\r\n\tat org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:70)\r\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:174)\r\n\tat org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:294)\r\n\tat org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:98)\r\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:185)\r\n\tat org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:92)\r\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:185)\r\n\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:688)\r\n\tat com.hoolinks.dcl.service.impl.InvtBillProductServiceImpl$$EnhancerBySpringCGLIB$$cd669908.create(<generated>)\r\n\tat com.alibaba.dubbo.common.bytecode.Wrapper23.invokeMethod(Wrapper23.java)\r\n\tat com.alibaba.dubbo.rpc.proxy.javassist.JavassistProxyFactory$1.doInvoke(JavassistProxyFactory.java:46)\r\n\tat com.alibaba.dubbo.rpc.proxy.AbstractProxyInvoker.invoke(AbstractProxyInvoker.java:72)\r\n\tat com.alibaba.dubbo.rpc.protocol.InvokerWrapper.invoke(InvokerWrapper.java:53)\r\n\tat com.alibaba.dubbo.rpc.filter.ExceptionFilter.invoke(ExceptionFilter.java:64)\r\n\tat com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)\r\n\tat com.alibaba.dubbo.monitor.support.MonitorFilter.invoke(MonitorFilter.java:75)\r\n\tat com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)\r\n\tat com.alibaba.dubbo.rpc.filter.TimeoutFilter.invoke(TimeoutFilter.java:42)\r\n\tat com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)\r\n\tat com.alibaba.dubbo.rpc.protocol.dubbo.filter.TraceFilter.invoke(TraceFilter.java:78)\r\n\tat com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)\r\n\tat com.alibaba.dubbo.rpc.filter.ContextFilter.invoke(ContextFilter.java:70)\r\n\tat com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)\r\n\tat com.alibaba.dubbo.rpc.filter.GenericFilter.invoke(GenericFilter.java:132)\r\n\tat com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)\r\n\tat com.alibaba.dubbo.rpc.filter.ClassLoaderFilter.invoke(ClassLoaderFilter.java:38)\r\n\tat com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)\r\n\tat com.alibaba.dubbo.rpc.filter.EchoFilter.invoke(EchoFilter.java:38)\r\n\tat com.alibaba.dubbo.rpc.protocol.ProtocolFilterWrapper$1.invoke(ProtocolFilterWrapper.java:91)\r\n\tat com.alibaba.dubbo.rpc.protocol.dubbo.DubboProtocol$1.reply(DubboProtocol.java:113)\r\n\tat com.alibaba.dubbo.remoting.exchange.support.header.HeaderExchangeHandler.handleRequest(HeaderExchangeHandler.java:84)\r\n\tat com.alibaba.dubbo.remoting.exchange.support.header.HeaderExchangeHandler.received(HeaderExchangeHandler.java:170)\r\n\tat com.alibaba.dubbo.remoting.transport.DecodeHandler.received(DecodeHandler.java:52)\r\n\tat com.alibaba.dubbo.remoting.transport.dispatcher.ChannelEventRunnable.run(ChannelEventRunnable.java:82)\r\n\tat java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)\r\n\tat java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)\r\n\tat java.lang.Thread.run(Thread.java:745)\r\n";

//        String str = "Exception in thread \"main\" java.lang.StringIndexOutOfBoundsException: String index out of range: -1\n" +
//                "\tat java.lang.String.substring(String.java:1960)\n" +
//                "\tat zzp.util.test.StringTest.main(StringTest.java:12)";

        // 获取当前系统的换行符
        String lineSeparator = (String) AccessController.doPrivileged(new GetPropertyAction("line.separator"));
        String sub = str.substring(str.indexOf(":") + 1, str.indexOf(lineSeparator));
        System.out.println(sub);
        System.out.println("换行符：" + lineSeparator + "，结束");

        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            String exceptionStr = ExceptionPrintUtil.printStackTraceToString(e);
            System.out.println(ExceptionPrintUtil.analysisExceptionMessage(exceptionStr));
        }


    }
}
