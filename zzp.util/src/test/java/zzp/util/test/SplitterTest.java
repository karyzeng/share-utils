package zzp.util.test;

import com.google.common.base.Splitter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2020.12.28
 **/
public class SplitterTest {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        List<String> list = Splitter.on(",").splitToList("123,234,566,123,566");
        set.addAll(list);
        System.out.println(set);

    }

}
