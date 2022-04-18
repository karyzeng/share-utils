package com.zzp.zsok.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.lang.Console;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description 将推送的报关单数据生成JSON文件
 * @Author Garyzeng
 * @since 2022.04.12
 **/
public class BillJsonUtil {

    public static void main(String[] args) {

        // 存放json文件的目录
        String folderPath = "/Users/zzp/Documents/工作/hoolinks/20220412/报关单JSON数据";
        String csvFilePath = "/Users/zzp/Documents/工作/hoolinks/20220412/欧科-查询推送到云票通的报关单数据.csv";

//        // 生成文件
//        System.out.println("---- 开始生成报关单json文件 ----");
//        createBillJsonFiles(folderPath, csvFilePath);
//        System.out.println("---- 完成生成报关单json文件 ----");

        // 读取文件
        File[] files = FileUtil.ls(folderPath);
        List<File> fileList = Arrays.asList(files).stream().filter(f -> f.getName().contains(".json")).collect(Collectors.toList());

        // 根据文件名升序排序
        fileList = fileList.stream().sorted(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }).collect(Collectors.toList());

        // 将文件列表转换为Map<String, JSONObject>
        Map<String, JSONObject> billMap = convertBillMap(fileList);
        Console.log(billMap.size());

    }

    private static void createBillJsonFiles(String folderPath, String csvFilePath) {

        CsvReader reader = CsvUtil.getReader();
        //从文件中读取CSV数据
        CsvData data = reader.read(FileUtil.file(csvFilePath), CharsetUtil.CHARSET_GBK);
        List<CsvRow> rows = data.getRows();

        for (int i = 1; i < rows.size(); i++) {
            // i = 1 表示跳过表头，表头下标为0
            CsvRow csvRow = rows.get(i);
            String fileName = getFormatDateStr(csvRow.getRawList().get(5)) + ".json";
            String filePath = folderPath + File.separator + fileName;

            // 保存为json文件
            FileUtil.touch(filePath);
            FileWriter writer = new FileWriter(filePath);
            writer.write(csvRow.getRawList().get(9));
        }
    }

    private static String getFormatDateStr(String origDateStr) {
        Date date = DateUtil.parse(origDateStr, "MMM dd, yyyy @ HH:mm:ss.SSS", Locale.UK);
        return DateUtil.format(date, "yyyyMMddHHmmssSSS");
    }

    private static Map<String, JSONObject> convertBillMap(List<File> fileList) {
        if (CollectionUtil.isEmpty(fileList)) {
            return null;
        }

        Map<String, JSONObject> map = new HashMap<>();
        for (File file : fileList) {
            Console.log(file.getName());
            String json = FileUtil.readString(file, Charset.forName("UTF-8"));
            Console.log(json);
            JSONObject jsonObject = JSON.parseObject(json);
            JSONArray bills = jsonObject.getJSONArray("bills");
            if (bills.size() <= 0) {
                continue;
            }

            for (int i = 0; i < bills.size(); i++) {
                JSONObject bill = bills.getJSONObject(i);
                if (bill == null) {
                    continue;
                }

                String qpCustomCode = bill.getString("qpCustomCode");
                if (qpCustomCode == null || qpCustomCode.equals("")) {
                    continue;
                }
                map.put(qpCustomCode, bill);
            }
        }

        return map;
    }

}
