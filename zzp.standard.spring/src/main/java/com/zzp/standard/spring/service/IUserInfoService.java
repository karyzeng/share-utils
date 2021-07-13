package com.zzp.standard.spring.service;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.zzp.standard.spring.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzp.standard.spring.vo.UserInfoVo;

import java.util.List;

/**
 * <p>
 *  用户信息 服务类
 * </p>
 *
 * @author zzp
 * @since 2021-07-11
 */
public interface IUserInfoService extends IService<UserInfo> {

    void saveUserInfo(UserInfoVo userInfoVo) throws ApiException;

    void delUserInfos(List<Integer> userIds) throws ApiException;

    void updateStatus(List<Integer> userIds, Integer status) throws ApiException;

}
