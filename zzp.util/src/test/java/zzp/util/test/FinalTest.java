package zzp.util.test;

import com.block.queue.User;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2019.05.23
 **/
public class FinalTest {

    private final User user = new User();

    public void setUser() {
//        user = new User();
    }

    public static void main(String[] args) {
        FinalTest finalTest = new FinalTest();
        finalTest.setUser();
    }

}
