package com.zzp.lambda.util;

import com.google.common.base.Splitter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description Java 8 Stream Util
 * @Author karyzeng
 * @since 2020.12.30
 **/
public class StreamUtil {

    public static void main(String[] args) {
        String str = "1,2,3";
        List<Integer> intList = Splitter.on(",").splitToStream(str).map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(intList);
    }

}
