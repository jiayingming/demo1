package com.dianxing.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/api/captcha")
public class CaptchaController {

    @Autowired
    private Producer captchaProducer;

    @GetMapping("/image")
    public void getCaptcha(HttpServletResponse response, HttpSession session) throws IOException {
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        String capText = captchaProducer.createText();
        session.setAttribute("captcha", capText);

        BufferedImage bi = captchaProducer.createImage(capText);
        ImageIO.write(bi, "jpg", response.getOutputStream());
    }
}