/**
 * @author Oliver
 * @date 10/18/2022 3:05 PM
 */
package com.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/simple")
    public String simple(ModelMap map) {
        map.put("thymeleafText", "aaaaaa");
        map.put("number1", 2022);
        map.put("number2", 3);
        return "simple";
    }

    @GetMapping("/test")
    public String test(ModelMap map) {
        map.put("title", "Thymeleaf 语法测试");
        map.put("testString", "涐是一个Spring boot");
        map.put("bool", true);
        map.put("testArray", new Integer[]{2022,2023,2024});
        map.put("testList", Arrays.asList("Spring", "Spring Boot", "Thymeleaf", "MyBatis", "Java"));

        Map testMap = new HashMap();
        testMap.put("platform", "aaaa");
        testMap.put("title", "play");
        testMap.put("author", "game");
        map.put("testMap", testMap);
        map.put("testDate", new Date());
        return "test";

    }
}
