package com.zzp.standard.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 操作日志AOP基类
 * @Author karyzeng
 * @since 2021.08.31
 **/
public abstract class BaseLogAspect {

    /**
     * 声明切入点，表明只有在方法上引用@Log注解才会被AOP拦截执行
     */
    @Pointcut("@annotation(com.zzp.standard.spring.annotations.Log)")
    public void pointcut() {

    }

    /**
     * 声明环绕通知，也是模板方法
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        return this.handleAround(point);
    }

    protected abstract Object handleAround(ProceedingJoinPoint point) throws Throwable;

    /**
     * 获取参数列表
     *
     * @param joinPoint
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    protected Map<String, Object> getFieldsName(ProceedingJoinPoint joinPoint) {
        // 参数值
        Object[] args = joinPoint.getArgs();
        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String[] parameterNames = pnd.getParameterNames(method);
        Map<String, Object> paramMap = new HashMap<>(32);
        for (int i = 0; i < parameterNames.length; i++) {
            paramMap.put(parameterNames[i], args[i]);
        }
        return paramMap;
    }

    /**
     * 将异常信息转换成字符串
     *
     * @param t 异常
     *
     * @return String
     */
    protected String printStackTraceToString(Throwable t) {
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw, true);) {
            t.printStackTrace(pw);
            String stackTraceString = sw.getBuffer().toString();
            return stackTraceString;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
