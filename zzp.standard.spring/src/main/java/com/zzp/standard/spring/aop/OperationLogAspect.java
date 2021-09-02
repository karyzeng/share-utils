package com.zzp.standard.spring.aop;

import com.alibaba.fastjson.JSON;
import com.zzp.standard.spring.annotations.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description 操作日志AOP类
 * @Author karyzeng
 * @since 2021.08.31
 **/
@Aspect // 声明为一个切面
@Component
public class OperationLogAspect extends BaseLogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected Object handleAround(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        // 获得参数列表
        Map<String, Object> args = this.getFieldsName(point);

        // 获得@Log注解
        MethodSignature signature = (MethodSignature) point.getSignature();
        Log log = signature.getMethod().getAnnotation(Log.class);

        // 异常信息
        String exceptionStr = null;

        // 执行方法
        try {
            result = point.proceed();
        } catch (Exception e) {
            exceptionStr = this.printStackTraceToString(e);
            throw e;
        } finally {
            logger.info("入参：{}，返回值：{}，注解内容：{}，异常信息：{}", JSON.toJSONString(args), JSON.toJSONString(result), log.value(), exceptionStr);
        }

        return result;
    }
}
