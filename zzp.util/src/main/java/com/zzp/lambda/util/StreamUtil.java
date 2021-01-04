package com.zzp.lambda.util;

import com.google.common.base.Splitter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description Java 8 Stream Util
 * @Author karyzeng
 * @since 2020.12.30
 **/
public class StreamUtil {

    public static void main(String[] args) {
        String str = "1,2,3";
        List<Integer> list = convertIntList(str, ",");
        List<Integer> evenList = filterEvenNumber(list);
        System.out.println(evenList);

        String str1 = "5,6,7,10";
        String str2 = "9,10,11";
        List<Integer> mergeList = mergeList(convertIntList(str1, ","), convertIntList(str2, ","), true);
        System.out.println(mergeList);
    }

    /**
     * 将str字符串根据separator分隔符分割成List<Integer>
     * @param str 字符串
     * @param separator 分隔符
     * @return
     */
    public static List<Integer> convertIntList(String str, String separator) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        return Splitter.on(separator).splitToStream(str).map(Integer::valueOf).collect(Collectors.toList());
    }

    /**
     * 将list列表中的偶数过滤出来
     * @param list
     * @return
     */
    public static List<Integer> filterEvenNumber(List<Integer> list) {
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    }

    /**
     * 合并两个list
     * @param list1
     * @param list2
     * @param distinct true表示去重，false表示不去重
     * @return
     */
    public static List<Integer> mergeList(List<Integer> list1, List<Integer> list2, boolean distinct) {
        if (CollectionUtils.isEmpty(list1)) {
            return list2;
        }

        if (CollectionUtils.isEmpty(list2)) {
            return list1;
        }

        if (distinct) {
            return Stream.of(list1, list2).flatMap(Collection::stream).distinct().collect(Collectors.toList());
        }
        return Stream.of(list1, list2).flatMap(Collection::stream).collect(Collectors.toList());
    }

}
