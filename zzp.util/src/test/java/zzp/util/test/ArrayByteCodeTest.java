package zzp.util.test;

/**
 * @Description 数组字节码测试类
 * @Author karyzeng
 * @since 2020.06.19
 **/
public class ArrayByteCodeTest {

    public static void main(String[] args) {
        ArrayByteCodeTest test = new ArrayByteCodeTest();
        System.out.println(test.sum(4));
    }

    private int sum(int num) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int total = 0;
        for (int i = 0; i < num; i++) {
            total += arr[i];
        }
        return total;
    }

}
