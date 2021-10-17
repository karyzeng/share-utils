package com.zzp.standard.spring.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息
 * </p>
 *
 * @author zzp
 * @since 2021-07-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user_info")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录名
     */
    private String loginId;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 状态，1表示启用，0表示禁用
     */
    private Integer status;

    /**
     * 是否删除，1表示是，0表示否
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Boolean isDelete;


}
