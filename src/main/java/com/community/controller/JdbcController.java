/**
 * @author Oliver
 * @date 10/18/2022 8:05 PM
 */
package com.community.controller;

import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    // 自动配置，因此可以直接通过 @Autowired 注入
    @Autowired
    JdbcTemplate jdbcTemplate;

    // 查询所有记录
    @GetMapping("/users/queryAll")
    public List<Map<String, Object>> queryAll() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from tb_user;");
        return list;
    }

    // 新增一条记录
    @GetMapping("/users/insert")
    public Object insert(String name, String password) {
        if(StringUtils.isNullOrEmpty(name) || StringUtils.isNullOrEmpty(password))
        {
            return false;
        }
        jdbcTemplate.execute("insert into tb_user(`name`,`password`) value (\"" + name + "\",\"" + password + "\")");
        return true;
    }



}
