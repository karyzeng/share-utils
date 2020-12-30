package zzp.util.test;

import com.alibaba.fastjson.JSON;
import junit.framework.Assert;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddressTest {

    public static void main(String[] args) {
        Integer a = 0;
        String s = "zzp";
        System.out.println("a:" + a.hashCode());
        System.out.println("b:" + s.hashCode());

        a = 1234;
        s = "zzpzjl";

        System.out.println("a:" + a.hashCode());
        System.out.println("b:" + s.hashCode());


        Integer j1 = 2;
        Integer j2 = 2;
        System.out.println("j1 = j2? " + (j1 == j2));  //true
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(j2,129);
            System.out.println( "j1+"+j1+"+j2+" + j2
                    +"\nSystem.identityHashCode(j1)"+System.identityHashCode(j1)
                    +"\nSystem.identityHashCode(j2)"+System.identityHashCode(j2)
                    +"\nj1 == j2" + (j1 == j2));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Integer j3 = 2;
        Integer j4 = 2;
        System.out.println("j3+"+j3+"\nSystem.identityHashCode(j3)"+System.identityHashCode(j3)+"\nj3 = j4? " + (j3 == j4));

        List<User> list = new ArrayList<User>();
//        User user = new User();
//        user.setId(1);
//        list.add(user);
//        User user2 = new User();
//        user2.setId(2);
//        list.add(user2);
        System.out.println(JSON.toJSONString(list));

        String str = "aabb,,,";
        String[] strArr = str.split(",");
        List<String> list2 = Arrays.asList(strArr);
        System.out.println(list2.toString());

        String json = "{\"timestamp\":\"2020-09-27 16:09:26\",\"status\":500,\"error\":\"Internal Server Error\",\"message\":\"FeignApiException:测试异常\",\"path\":\"/open/order/serviceName/get\"}";
        HttpResult result = JSON.parseObject(json, HttpResult.class);
        System.out.println(result);

        StringBuffer sb = new StringBuffer();
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.lastIndexOf("，"));
        }
        System.out.println("sb：" + sb.toString());

        BigDecimal bigDecimal = new BigDecimal("103510.4600000000").setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal.toString());

        String json2 = "[{\"index\":1,\"name\":\"品牌类型\",\"type\":1}]";

        String json3 = "[{\\\"index\\\":1,\\\"name\\\":\\\"品牌类型\\\",\\\"type\\\":1}]";
        System.out.println(json2.replaceAll("\"", "\\\\\""));
        System.out.println(json3);

    }
}
