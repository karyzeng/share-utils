package com.zzp.zsok.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.lang.Console;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.CharsetUtil;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @Description 将推送的报关单数据生成JSON文件
 * @Author Garyzeng
 * @since 2022.04.12
 **/
public class BillJsonUtil {

    public static void main(String[] args) {

        String folderPath = "/Users/zzp/Documents/工作/hoolinks/20220412/报关单JSON数据";

        CsvReader reader = CsvUtil.getReader();
        //从文件中读取CSV数据
        CsvData data = reader.read(FileUtil.file("/Users/zzp/Documents/工作/hoolinks/20220412/欧科-查询推送到云票通的报关单数据.csv"), CharsetUtil.CHARSET_GBK);
        List<CsvRow> rows = data.getRows();

        CsvRow row1 = rows.get(1);
        Console.log(row1.getRawList().get(5), row1.getRawList().get(9));
        Date date = DateUtil.parse(row1.getRawList().get(5), "MMM dd, yyyy @ HH:mm:ss.SSS", Locale.UK);
//        System.out.println(date);

        String fileName = DateUtil.format(date, "yyyyMMddHHmmssSSS");
        String filePath = folderPath + File.separator + fileName + ".json";

        FileUtil.touch(filePath);
        FileWriter writer = new FileWriter(filePath);
        writer.write(row1.getRawList().get(9));


        //遍历行
//        for (CsvRow csvRow : rows) {
//            //getRawList返回一个List列表，列表的每一项为CSV中的一个单元格（既逗号分隔部分）
//            Console.log(csvRow.getRawList().get(5), csvRow.getRawList().get(9));
//        }
    }

}
