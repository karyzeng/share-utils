package com.zzp.standard.spring.proxy.invokers;

import com.alibaba.fastjson.JSON;
import com.zzp.base.results.Result;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @Description HttpApi代理调用者
 * @Author karyzeng
 * @since 2021.09.01
 **/
public class HttpApiProxyInvoker {

    public static <T> Result invoke(T params, Function<T, Result> func) {

        Result result = func.apply(params);

        return result;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "zzp");
        map.put("age", "18");
        Result result = HttpApiProxyInvoker.invoke(map, (param) -> {
            Result<String> rtn = Result.ok("成功", param.get("name"));
            return rtn;
        });
        System.out.println(JSON.toJSONString(result));
    }

}
