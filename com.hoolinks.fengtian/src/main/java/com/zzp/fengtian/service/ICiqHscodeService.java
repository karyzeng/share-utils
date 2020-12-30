package com.zzp.fengtian.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzp.fengtian.entity.CiqHscode;

/**
 * <p>
 *  通关作业ciqHscode 服务类
 * </p>
 *
 * @author Garyzeng
 * @since 2020-12-29
 */
public interface ICiqHscodeService extends IService<CiqHscode> {

    void createCiqHscodeSQLFile();

    /**
     * 分页查询CiqHscode
     * @param current 页码
     * @param size 分页大小
     * @return
     */
    IPage<CiqHscode> page(long current, long size);

}
