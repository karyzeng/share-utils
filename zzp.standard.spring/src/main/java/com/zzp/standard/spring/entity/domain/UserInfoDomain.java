package com.zzp.standard.spring.entity.domain;

import com.zzp.standard.spring.entity.UserInfo;
import com.zzp.standard.spring.service.IUserInfoService;
import com.zzp.standard.spring.vo.UserInfoVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 用户信息Domain
 * @Author zzp
 * @since 2021.07.11
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Component
public class UserInfoDomain extends UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Autowired
    private IUserInfoService userInfoService;

    public UserInfo saveFillData(UserInfoVo userInfoVo) {
        UserInfo userInfo = null;
        Date nowDate = new Date();
        if (userInfoVo.getId() != null) {
            // 更新
            userInfo = userInfoService.getById(userInfoVo.getId());
            userInfo.setUserName(userInfoVo.getUserName());
            userInfo.setLoginId(userInfoVo.getLoginId());
            userInfo.setPhone(userInfoVo.getPhone());
        } else {
            // 新增
            userInfo = new UserInfo();
            BeanUtils.copyProperties(userInfoVo, userInfo);
            userInfo.setCreateTime(nowDate);
        }
        userInfo.setUpdateTime(nowDate);
        return userInfo;
    }

}
