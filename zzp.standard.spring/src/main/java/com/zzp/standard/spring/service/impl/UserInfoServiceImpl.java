package com.zzp.standard.spring.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.zzp.standard.spring.annotations.Log;
import com.zzp.standard.spring.entity.UserInfo;
import com.zzp.standard.spring.entity.domain.UserInfoDomain;
import com.zzp.standard.spring.mapper.UserInfoMapper;
import com.zzp.standard.spring.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzp.standard.spring.service.validator.UserInfoServiceValidator;
import com.zzp.standard.spring.vo.UserInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  用户信息 服务实现类
 * </p>
 *
 * @author zzp
 * @since 2021-07-11
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserInfoServiceValidator userInfoServiceValidator;

    @Autowired
    private UserInfoDomain userInfoDomain;

    @Override
    @Transactional
    @Log("保存用户信息")
    public void saveUserInfo(UserInfoVo userInfoVo) throws ApiException {

        // 校验
        userInfoServiceValidator.saveValidate(userInfoVo);

        // 构造PO
        UserInfo userInfo = userInfoDomain.saveFillData(userInfoVo);

        // 保存
        this.saveOrUpdate(userInfo);

    }

    @Override
    @Transactional
    public void delUserInfos(List<Integer> userIds) throws ApiException {

        // 校验
        userInfoServiceValidator.delValidate(userIds);

        // 删除
        this.removeByIds(userIds);
    }

    @Override
    @Transactional
    @Log("更新用户状态")
    public void updateStatus(List<Integer> userIds, Integer status) throws ApiException {
        // 校验
        userInfoServiceValidator.updateStatusValidate(null);

        // 查询出用户列表
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<UserInfo>();
        queryWrapper.in(UserInfo::getId, userIds);
        List<UserInfo> userInfos = this.list(queryWrapper);

        // 转换状态
        userInfos = userInfoDomain.transformationStatus(userInfos, status);

        // 更新
        this.updateBatchById(userInfos);

    }
}
