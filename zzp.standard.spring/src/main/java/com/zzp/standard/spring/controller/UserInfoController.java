package com.zzp.standard.spring.controller;


import com.baomidou.mybatisplus.extension.exceptions.ApiException;
import com.zzp.base.results.Result;
import com.zzp.standard.spring.entity.UserInfo;
import com.zzp.standard.spring.service.IUserInfoService;
import com.zzp.standard.spring.vo.UserInfoOperationVo;
import com.zzp.standard.spring.vo.UserInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseBody
    @RequestMapping(value = "del", method = RequestMethod.POST)
    public Result<Boolean> del(@RequestBody UserInfoOperationVo operationVo) {
        try {
            userInfoService.delUserInfos(operationVo.getIds());
        } catch (ApiException e) {
            e.printStackTrace();
            logger.error("删除接口出现业务异常，异常信息为", e);
            return Result.failed(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除接口出现系统异常，异常信息为", e);
            return Result.failed("删除失败");
        }
        return Result.ok("删除成功");
    }

    @ResponseBody
    @RequestMapping(value = "updateStatus", method = RequestMethod.POST)
    public Result<Boolean> updateStatus(@RequestBody UserInfoOperationVo operationVo) {
        try {
            userInfoService.updateStatus(operationVo.getIds(), operationVo.getStatus());
        } catch (ApiException e) {
            e.printStackTrace();
            logger.error("更新状态接口出现业务异常，异常信息为", e);
            return Result.failed(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新状态接口出现系统异常，异常信息为", e);
            return Result.failed("更新失败");
        }
        return Result.ok("更新成功");
    }

    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Result<List<UserInfo>> listUserInfos(@RequestParam(value = "ids", required = false)List<Integer> ids, @RequestParam(value = "loginId", required = false)String loginId) {
        try {
            List<UserInfo> userInfos = userInfoService.listUserInfo(ids, loginId);
            return Result.ok("查询成功", userInfos);
        } catch (ApiException e) {
            e.printStackTrace();
            logger.error("查询用户信息接口出现业务异常，异常信息为", e);
            return Result.failed(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询用户信息接口出现系统异常，异常信息为", e);
            return Result.failed("查询失败");
        }
    }

}
