/**
 * @author Oliver
 * @date 10/18/2022 1:53 PM
 */
package com.community.controller;

import com.community.entity.SaleGoods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping(value = "/get/httpmessageconverter", method = RequestMethod.GET)
    // 添加 @ResponseBody 注解后，Spring Boot 会直接将对象转换为 json 格式并输出为响应信息
    @ResponseBody
    public SaleGoods httpMessageConvertTest()
    {
        SaleGoods saleGoods = new SaleGoods();
        saleGoods.setGoodsName("Apple");
        saleGoods.setId(1);
        saleGoods.setOnSale(true);
        saleGoods.setType(1);
        saleGoods.setWeight(3);
        return saleGoods;
    }

    @RequestMapping(value = "test/httpmessageconvert", method = RequestMethod.POST)
    @ResponseBody
    // 添加 @RequestBody 接收前端请求并将参数转换为后端定义的对象
    // 使用注解将前端传输的参数直接转换为 SaleGoods 对象
    public SaleGoods httpsMessageConvertTest2(@RequestBody SaleGoods saleGoods)
    {
        System.out.println(saleGoods.toString());
        saleGoods.setType(saleGoods.getType() + 1);
        saleGoods.setGoodsName("Name: " + saleGoods.getGoodsName());
        return saleGoods;

    }


}
