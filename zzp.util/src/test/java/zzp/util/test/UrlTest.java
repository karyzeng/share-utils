package zzp.util.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URLDecoder;

/**
 * @Description url测试
 * @Author karyzeng
 * @since 2021.06.30
 **/
public class UrlTest {

    public static void main(String[] args) throws Exception {
        File file = new File("E:\\zzp\\项目\\金关二期\\20210731\\jbdata.txt");
        String str = null;
        str = FileUtils.readFileToString(file, "utf-8");
        String json = URLDecoder.decode(str);
        JSONObject jsonObject = JSONObject.parseObject(json);
        System.out.println(json);
    }

}
