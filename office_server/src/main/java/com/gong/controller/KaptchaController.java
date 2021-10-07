package com.gong.controller;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 验证码
 *
 * @author CodeSniper
 * @since 2021-09-08
 */
@RestController
@Api(tags = "验证码")
public class KaptchaController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @ApiOperation(value = "验证码")
    @GetMapping(value = "/kaptcha",produces = "image/jpeg")
    public void createKaptcha(HttpServletRequest request, HttpServletResponse response) {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setContentType("image/jpeg");
        //---- 生成验证码 begin ----
        //获取验证码文本内容
        String text = defaultKaptcha.createText();
        System.out.println("验证码内容:" + text);
        //将验证码文本内容放入session
        request.getSession().setAttribute("kaptcha", text);
        //根据文本验证码内容创建图形验证码
        BufferedImage image = defaultKaptcha.createImage(text);
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(image,"jpg",outputStream);
            outputStream.flush();
        } catch (IOException e) {
            if (null!=outputStream){
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        //---- 生成验证码 end ----

    }
}
