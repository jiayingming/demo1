package com.dianxing.controller;

import com.dianxing.pojo.Result;
import com.dianxing.pojo.User;
import com.dianxing.service.LoginService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/login")
@Tag(name = "登录界面")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody User user) {
        log.info("登录请求: username={}", user.getUsername());
        User authenticatedUser = loginService.login(user);
        return authenticatedUser != null ?
                Result.success(authenticatedUser) :
                Result.error("用户名或密码错误");
    }
}