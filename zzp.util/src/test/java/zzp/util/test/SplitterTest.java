package zzp.util.test;

import com.google.common.base.Splitter;

import java.util.List;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2020.12.28
 **/
public class SplitterTest {

    public static void main(String[] args) {
        List<String> list = Splitter.on(",").splitToList("");
        System.out.println(list);
    }

}
