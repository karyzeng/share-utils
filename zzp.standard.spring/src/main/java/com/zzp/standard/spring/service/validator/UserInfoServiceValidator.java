package com.zzp.standard.spring.service.validator;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.zzp.standard.spring.entity.UserInfo;
import com.zzp.standard.spring.entity.domain.UserInfoDomain;
import com.zzp.standard.spring.service.IUserInfoService;
import com.zzp.standard.spring.vo.UserInfoVo;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description 用户信息 校验器
 * @Author zzp
 * @since 2021.07.11
 **/
@Component
public class UserInfoServiceValidator {

    @Autowired
    private IUserInfoService userInfoService;

    @Autowired
    private UserInfoDomain userInfoDomain;

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

    public void delValidate(List<Integer> userIds) throws ApiException {
        if (CollectionUtils.isEmpty(userIds)) {
            throw new ApiException("用户id列表不能为空");
        }

        for (Integer userId : userIds) {
            UserInfo userInfo = userInfoService.getById(userId);
            if (!userInfoDomain.isDel(userInfo)) {
                throw new ApiException("存在不能删除的用户");
            }
        }
    }

    public void updateStatusValidate(Integer status) throws ApiException {

    }

}
