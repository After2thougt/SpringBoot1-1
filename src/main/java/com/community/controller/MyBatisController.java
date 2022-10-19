/**
 * @author Oliver
 * @date 10/19/2022 6:13 PM
 */
package com.community.controller;

import com.community.dao.UserDao;
import com.community.entity.User;
import com.mysql.cj.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MyBatisController {
    @Resource
    UserDao userDao;

    // 查询所有记录
    @GetMapping("/users/mybatis/queryAll")
    public List<User> queryAll() {
        return userDao.findAllUsers();
    }

    // 新增一条记录
    @GetMapping("/users/mybatis/insert")
    public Boolean insert(String name, String password) {
        if(StringUtils.isNullOrEmpty(name) || StringUtils.isNullOrEmpty(password)){

            return false;
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return userDao.insertUser(user) > 0;
    }

    // 修改一条记录
    @GetMapping("/users/mybatis/update")
    public Boolean insert(Integer id, String name, String password){
        if(id==null|| id<1||StringUtils.isNullOrEmpty(name)||StringUtils.isNullOrEmpty(password)) {
            return false;
        }
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        return userDao.updateUser(user)>0;
    }

    // 删除一条记录
    @GetMapping("/users/mybatis/delete")
    public Boolean insert(Integer id) {
        if(id==null || id<1) {
            return false;
        }
        return userDao.delUser(id) > 0;
    }
}
