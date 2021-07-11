package com.zzp.standard.spring.service.validator;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.zzp.standard.spring.vo.UserInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @Description 用户信息 校验器
 * @Author zzp
 * @since 2021.07.11
 **/
@Component
public class UserInfoServiceValidator {

    public void saveValidate(UserInfoVo userInfoVo) throws ApiException {
        if (StringUtils.isBlank(userInfoVo.getUserName())) {
            throw new ApiException("用户名不能为空");
        }

        if (StringUtils.isBlank(userInfoVo.getLoginId())) {
            throw new ApiException("登录名不能为空");
        }
    }

    public String saveValidate2(UserInfoVo userInfoVo) {
        if (StringUtils.isBlank(userInfoVo.getUserName())) {
            return "用户名不能为空";
        }

        if (StringUtils.isBlank(userInfoVo.getLoginId())) {
            return "登录名不能为空";
        }

        return "";
    }

}
