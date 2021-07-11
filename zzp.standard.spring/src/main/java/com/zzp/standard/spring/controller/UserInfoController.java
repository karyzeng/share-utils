package com.zzp.standard.spring.controller;


import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.zzp.base.results.Result;
import com.zzp.standard.spring.service.IUserInfoService;
import com.zzp.standard.spring.vo.UserInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  用户信息 前端控制器
 * </p>
 *
 * @author zzp
 * @since 2021-07-11
 */
@RestController
@RequestMapping("/user-info")
public class UserInfoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserInfoService userInfoService;

    @ResponseBody
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Result<Boolean> save(@RequestBody UserInfoVo userInfoVo) {
        try {
            userInfoService.saveUserInfo(userInfoVo);
        } catch (ApiException e) {
            e.printStackTrace();
            logger.error("保存接口出现业务异常，异常信息为", e);
            return Result.failed(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("保存接口出现系统异常，异常信息为", e);
            return Result.failed("保存失败");
        }
        return Result.ok("保存成功");
    }

}
