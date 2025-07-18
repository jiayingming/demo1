package com.dianxing.controller;

import com.dianxing.pojo.Result;
import com.dianxing.pojo.User;
import com.dianxing.service.LoginService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("api/login")
@Tag(name = "登录界面")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody User user, HttpSession session) {
        log.info("登录请求: username={}", user.getUsername());

        // 验证验证码
        String sessionCaptcha = (String) session.getAttribute("captcha");
        if (sessionCaptcha == null || !sessionCaptcha.equalsIgnoreCase(user.getCaptcha())) {
            return Result.error("验证码错误");
        }

        // 清除验证码session
        session.removeAttribute("captcha");

        User authenticatedUser = loginService.login(user);
        return authenticatedUser != null ?
                Result.success(authenticatedUser) :
                Result.error("用户名或密码错误");
    }
}