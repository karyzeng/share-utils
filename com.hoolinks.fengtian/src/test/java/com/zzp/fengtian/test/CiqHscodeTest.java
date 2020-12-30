package com.zzp.fengtian.test;

import com.zzp.fengtian.service.ICiqHscodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description 通关作业ciqHscode测试类
 * @Author karyzeng
 * @since 2020.12.29
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CiqHscodeTest {

    @Autowired
    private ICiqHscodeService ciqHscodeService;

    @Test
    public void createFengtianCiqHsCodeSQLFile() {
        ciqHscodeService.createCiqHscodeSQLFile();
    }

}
