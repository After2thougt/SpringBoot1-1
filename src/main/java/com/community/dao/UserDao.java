/**
 * @author Oliver
 * @date 10/19/2022 6:13 PM
 */
package com.community.dao;

import com.community.entity.User;

import java.util.List;

public interface UserDao {

    /**
     * 返回数据列表
     * @return
     */
    List<User> findAllUsers();

    /**
     * 增加
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 修改
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除
     * @param user
     * @return
     */
    int delUser(Integer user);

}
