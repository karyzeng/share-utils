package com.zzp.standard.spring.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @Description MybatisPlus元数据处理器
 * @Author Garyzeng
 * @since 2021.10.10
 **/
@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("isDelete", false, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
