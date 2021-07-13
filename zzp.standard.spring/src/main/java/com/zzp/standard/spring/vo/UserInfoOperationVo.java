package com.zzp.standard.spring.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Description 用户信息操作vo
 * @Author zzp
 * @since 2021.07.11
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfoOperationVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id列表
     */
    private List<Integer> ids;

}
