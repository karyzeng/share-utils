package zzp.util.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 几种map的遍历，输出顺序的不同
 * @author karyzeng
 * @since 2019.06.03
 */
public class MapSortTest {

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("表头", 1);
        hashMap.put("表体", 2);
        print(hashMap);
        System.out.println("------------");

        Map<String, Integer> treeMap = new TreeMap<String, Integer>();
        treeMap.put("表头", 1);
        treeMap.put("表体", 2);
        print(treeMap);
        System.out.println("------------");

        Map<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        linkedHashMap.put("表头", 1);
        linkedHashMap.put("表体", 2);
        print(linkedHashMap);
        System.out.println("------------");

    }

    private static void print(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
    }

}
