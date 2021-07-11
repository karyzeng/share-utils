package com.zzp.standard.spring.service.impl;

import com.baomidou.mybatisplus.extension.exceptions.ApiException;
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
    public void saveUserInfo(UserInfoVo userInfoVo) throws ApiException {

        // 校验
        userInfoServiceValidator.saveValidate(userInfoVo);

        // 构造PO
        UserInfo userInfo = userInfoDomain.saveFillData(userInfoVo);

        // 保存
        this.saveOrUpdate(userInfo);

    }
}
