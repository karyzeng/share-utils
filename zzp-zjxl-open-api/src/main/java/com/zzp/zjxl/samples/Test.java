package com.zzp.zjxl.samples;

import com.openapi.sdk.service.DataExchangeService;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2022.07.12
 **/
public class Test {

    private static final String USER = "e948e5b4-dbdc-4eac-b952-2fdbf7567cbf";
    private static final String PWD = "0i6j3Y3q4T20K5G619m11ni43201x9";
    private static final String CID = "fb7faeb6-82c3-4cf8-89fc-55793addd26a";
    private static final String SRT = "a1994a7c-dffd-47ad-b30a-4e50a25a9f10";
    private static final String URL = "https://openapi-test.sinoiov.cn/save/apis/";

    public static void main(String[] args) {
        // 获取token
//        String token = getToken();
//        System.out.println("token：" + token);

        // 测试运输节点服务
        System.out.println(transTimeManageV2());
    }

    public static String getToken() {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("user", USER);
            map.put("pwd", PWD);
            map.put("cid", CID);
            map.put("srt", SRT);
            DataExchangeService des = new DataExchangeService(5000,8000);
            String result = des.postHttps(URL + "login", map);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String transTimeManageV2() {
        try {
            Map<String, String> map = new HashMap<>();
            map.put("token", "5c188335-a855-4ee8-93bd-f8af7dfe784c");
            map.put("cid", CID);
            map.put("srt", SRT);
            map.put("vnos", "陕YH0008_2");
            map.put("startLonlat", "113.471886,23.209591");
            map.put("endLonlat", "113.426416,23.133754");
            DataExchangeService des = new DataExchangeService(5000,8000);
            String result = des.postHttps(URL + "transTimeManageV2", map);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
