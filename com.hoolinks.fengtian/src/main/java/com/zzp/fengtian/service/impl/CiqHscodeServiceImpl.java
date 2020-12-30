package com.zzp.fengtian.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzp.fengtian.entity.CiqHscode;
import com.zzp.fengtian.mapper.CiqHscodeMapper;
import com.zzp.fengtian.service.ICiqHscodeService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *  通关作业ciqHscode 服务实现类
 * </p>
 *
 * @author Garyzeng
 * @since 2020-12-29
 */
@Service
public class CiqHscodeServiceImpl extends ServiceImpl<CiqHscodeMapper, CiqHscode> implements ICiqHscodeService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String prefix = "INSERT INTO `ozap_ciq_hscode`(`ciq_code`, `hs_code`, `update_date`, `create_date`, `name`, `hs_type`, `hs_name`) VALUES ";

    @Override
    public void createCiqHscodeSQLFile() {
        // SCP的t_ciq_hscode表总记录数
        int total = this.count();
        // 起始页码
        long current = 1;
        // 分页大小
        long size = 1000;
        // 总页数
        long pageCount = 0;
        if (total % size == 0) {
            pageCount = total / size;
        } else {
            pageCount = total / size + 1;
        }

        // 分页查询数据
        for (;current <= pageCount; current++) {
            logger.info("查询第{}页，分页大小为：" + size + "，总记录数：" + total + "，总页数：" + pageCount, current);
            IPage<CiqHscode> result = this.page(current, size);
            List<CiqHscode> ciqHscodes = result.getRecords();
            if (CollectionUtils.isEmpty(ciqHscodes)) {
                continue;
            }
            this.print(ciqHscodes);
        }
    }

    @Override
    public IPage<CiqHscode> page(long current, long size) {
        Page<CiqHscode> pageParam = new Page<CiqHscode>();
        pageParam.setCurrent(current);
        pageParam.setSize(size);

        LambdaQueryWrapper<CiqHscode> queryWrapper = new LambdaQueryWrapper<CiqHscode>();
        queryWrapper.orderByAsc(CiqHscode::getId);

        IPage<CiqHscode> result = page(pageParam, queryWrapper);

        return result;
    }

    private void print(List<CiqHscode> ciqHscodes) {
        List<String> sqls = new LinkedList<String>();
        for (CiqHscode ciqHscode : ciqHscodes) {
            String ciqCode = StringUtils.isBlank(ciqHscode.getCiqCode()) ? "NULL" : ciqHscode.getCiqCode();
            String hsCode = StringUtils.isBlank(ciqHscode.getHsCode()) ? "NULL" : ciqHscode.getHsCode();
            String updateDate = "NULL";
            String createDate = "NULL";
            String hsType = StringUtils.isBlank(ciqHscode.getHsType()) ? "NULL" : ciqHscode.getHsType();
            String name = StringUtils.isBlank(ciqHscode.getName()) ? "NULL" : ciqHscode.getName().replaceAll("\r|\n", "").replaceAll("'", "\\\\'");
            String hsName = StringUtils.isBlank(ciqHscode.getHsName()) ? "NULL" : ciqHscode.getHsName().replaceAll("\r|\n", "").replaceAll("'", "\\\\'");

            String sql = "(" + convertValue(ciqCode) + ", " + convertValue(hsCode) + ", " + convertValue(updateDate) + ", " + convertValue(createDate) + ", " + convertValue(name) + ", " + convertValue(hsType) + ", " + convertValue(hsName) + ");";
            sqls.add(prefix + sql);
        }
        File outFile = new File("E:\\fengtianTemp\\丰田系统更新ciqHscode2.sql");
        try {
            FileUtils.writeLines(outFile, sqls, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String convertValue(String value) {
        if ("NULL".equals(value)) {
            return "NULL";
        }
        return "'" + value + "'";
    }
}
