package com.zzp.fengtian.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 通关作业ciqHscode
 * </p>
 *
 * @author Garyzeng
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_ciq_hscode")
public class CiqHscode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 检验检疫编码
     */
    private String ciqCode;

    /**
     * 商品编码
     */
    private String hsCode;

    private Date createDate;

    private Date updateDate;

    /**
     * 名称
     */
    private String name;

    /**
     * HS名称
     */
    private String hsName;

    /**
     * 类型
     */
    private String hsType;


}
