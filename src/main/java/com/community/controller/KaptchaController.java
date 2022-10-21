/**
 * @author Oliver
 * @date 10/21/2022 6:30 PM
 */
package com.community.controller;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.base.Captcha;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class KaptchaController {

    @GetMapping("kaptcha")
    public void defalutKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {

        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/gif");

        // 设置宽、高，位数
        GifCaptcha captcha = new GifCaptcha(75, 30, 4);

        // 设置类型，数字字母混合
        captcha.setCharType(Captcha.TYPE_DEFAULT);

        // 设置字体
        captcha.setCharType(Captcha.FONT_10);

        // 验证码存入 session
        httpServletRequest.getSession().setAttribute("verifyCode", captcha.text().toLowerCase());

        // 输出图片流
        captcha.out(httpServletResponse.getOutputStream());
    }

    @GetMapping("/verify")
    @ResponseBody
    public String verify(@RequestParam("code") String code, HttpSession session) {
        if(!StringUtils.hasLength(code)) {
            return "验证码不能为空";
        }
        String kaptchaCode = session.getAttribute("verifyCode") + "";

        if(!StringUtils.hasLength(kaptchaCode) || !code.equals(kaptchaCode)) {
            return "验证码错误";
        }

        return "验证成功";
    }

}
