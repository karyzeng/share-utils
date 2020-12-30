package com.quote.log.convert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * @Description 财务系统报价日志转换
 * @Author karyzeng
 * @since 2019.09.12
 **/
public class QuoteLogTest {

    public static void main(String[] args) {
        String str = "[{\"oldVal\":170,\"nameDescription\":\"最终服务费\",\"name\":\"finalTotalAmount\",\"newVal\":250},{\"oldVal\":\"黄埔海运出口报关服务费\",\"nameDescription\":\"报价名称\",\"name\":\"productName\",\"newVal\":\"海运出口报关服务费\"},{\"oldVal\":1607817600000,\"nameDescription\":\"报价截止日期\",\"name\":\"endDate\",\"newVal\":1735084800000},{\"oldVal\":\"空\",\"nameDescription\":\"备注\",\"name\":\"remark\",\"newVal\":\"空\"}]";
    }

    public static String convert(String logStr) {
        if (StringUtils.isBlank(logStr)) {
            return null;
        }
        JSONArray jsonArray = JSON.parseArray(logStr);
        if (jsonArray != null && jsonArray.size() > 0) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0;i < jsonArray.size(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

            }
        }
        return null;
    }

}
