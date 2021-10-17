package com.zzp.standard.spring.security.controller;

import com.zzp.validate.code.util.DigitValidateCodeResult;
import com.zzp.validate.code.util.DigitValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 用户登录Controller
 * @Author Garyzeng
 * @since 2021.10.17
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/validateCode")
    public void validateCode(String key, HttpServletResponse response) throws IOException {

        // 设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        DigitValidateCodeResult digitValidateCodeResult = DigitValidateCodeUtils.getValidateCodeImage(60,20,4);

        request.getSession().setAttribute(key, digitValidateCodeResult.getRandomCode());


        // 输出图象到页面
        ImageIO.write(digitValidateCodeResult.getImage(), "JPEG", response.getOutputStream());
    }

}
