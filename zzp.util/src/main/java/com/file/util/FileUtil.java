package com.file.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description 文件工具类
 * @Author Garyzeng
 * @since 2019.10.15
 **/
public class FileUtil {

    /**
     * 获取文件夹下的所有文件
     * @param folder
     * @return
     */
    public static List<String> getFilePaths(File folder) {
        List<String> files = new ArrayList<String>();
        File[] subs = folder.listFiles();
        if (subs != null && subs.length > 0) {
            for (int i = 0; i < subs.length; i++) {
                File sub = subs[i];
                if (sub.isFile()) {
                    files.add(sub.getPath());
                }
            }
            return files;
        }
        return null;
    }

    /**
     * 获取文件夹下的所有文件
     * @param folder
     * @return
     */
    public static List<File> getFiles(File folder) {
        List<File> files = new ArrayList<File>();
        File[] subs = folder.listFiles();
        if (subs != null && subs.length > 0) {
            for (int i = 0; i < subs.length; i++) {
                File sub = subs[i];
                if (sub.isFile()) {
                    files.add(sub);
                }
            }
            return files;
        }
        return null;
    }

}
