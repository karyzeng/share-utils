package zzp.util.test;

import com.util.convert.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListUtilsTest {

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        int userSize = 1000000;

        long initUserStart = System.currentTimeMillis();
        for (int i = 0;i < userSize; i++) {
            User user = new User();
            Integer index = (i + 1);
            user.setId(index);
            user.setLoginId("loginId_" + index);
            user.setUserName("userName_" + index);
            users.add(user);
        }
        long initUserEnd = System.currentTimeMillis();
        System.out.println("初始化对象耗时：" + (initUserEnd - initUserStart) + "毫秒");

        long jsonStart = System.currentTimeMillis();
        List<Map> jsonList = ListUtils.convertListMap(users);
        long jsonEnd = System.currentTimeMillis();
        System.out.println("使用JSON方法转换耗时：" + (jsonEnd - jsonStart) + "毫秒");

        long beanStart = System.currentTimeMillis();
        List<Map> beanList = ListUtils.beanToMaps(users);
        long beanEnd = System.currentTimeMillis();
        System.out.println("使用BeanUils方法转换耗时：" + (beanEnd - beanStart) + "毫秒");
    }

}
