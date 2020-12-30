package zzp.util.test;

/**
 * @Description 测试将json字符串的""空字符串转换成null
 * @Author karyzeng
 * @since 2019.09.24
 **/
public class JsonEmptyToNullTest {

    public static void main(String[] args) {
        String str = "{\n\t\"id\":147,\n\t\"seqNo\":\"\",\n\t\"bondInvtNo\":\"157454847521d4587A\",\n\t\"decSeqNo\":\"\",\n\t\"entryNo\":\"\"}";
        System.out.println(str.replaceAll("\"\"", "null"));

    }
}
