/**
 * @author Oliver
 * @date 10/18/2022 3:05 PM
 */
package com.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf")
    public String hello(HttpServletRequest request,
                        @RequestParam(value = "description",
                                required = false,
                                defaultValue = "springboot-thymeleaf") String description) {
        request.setAttribute("description", description);
        return "thymeleaf";
    }

    @GetMapping("/attributes")
    public String attributes(ModelMap map) {
        map.put("title", "Thymeleaf 标签演示");
        map.put("th_id", "thymeleaf-input");
        map.put("th_name", "thymeleaf-input");
        map.put("th_value", 13);
        map.put("th_class","thymeleaf-class");
        map.put("th_href", "https://www.bing.com");

        return "attributes";
    }
}
