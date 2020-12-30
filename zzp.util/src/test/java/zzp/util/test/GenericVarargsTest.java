package zzp.util.test;

import com.block.queue.User;

import java.util.ArrayList;
import java.util.List;

public class GenericVarargsTest {

    public static void main(String[] args) {
        System.out.println(test(new User()));
    }

    public static <T> List<String> test(T t) {
        List<String> list = new ArrayList<String>();
        list.add(t.getClass().getName());
        return list;
    }

}
