package zzp.util.test;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2020.12.17
 **/
public class FileUtilsTest {

    public static void main(String[] args) {
        File file = new File("E:\\scptemp\\batchExportBillFile\\I\\20201216173106782");
        boolean sign = FileUtils.deleteQuietly(file);
        System.out.println(sign);
    }

}
