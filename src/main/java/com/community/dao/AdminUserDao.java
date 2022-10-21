package com.community.dao;

import com.community.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminUserDao {

    /**
     * 根据参数查询用户列表
     * @param param
     * @return
     */
    List<AdminUser> findAdminUsers(Map param);

    /**
     * 查询用户总数
     * @param param
     * @return
     */
    int getTotalAdminUser(Map param);

    /**
     * 根据登录名和密码获取用户记录
     * @param userName
     * @param passwordMD5
     * @return
     */
    AdminUser getAdminUserByUserNameAndPassword(@Param("userName") String userName,
                                                @Param("passwordMD5") String passwordMD5); // @Param注解的作用是给参数命名，参数命名后就能根据名称得到参数值，正确的将参数传入sql语句中

    /**
     * 根据userToken获取用户记录
     * @param userToken
     * @return
     */
    AdminUser getAdminUserByToken(String userToken);

    /**
     * 根据id获取用户记录
     * @param id
     * @return
     */
    AdminUser getAdminUserById(Long id);

    /**
     * 根据用户名获取用户记录
     * @param userName
     * @return
     */
    AdminUser getAdminUserByUserName(String userName);

    /**
     * 新增用户记录
     * @param user
     * @return
     */
    int addUser(AdminUser user);

    /**
     * 批量新增用户记录
     * @param adminUsers
     * @return
     */
    int insertUserBatch(@Param("adminUser") List<AdminUser> adminUsers);

    /**
     * 修改用户密码
     * @param userId
     * @param newPassword
     * @return
     */
    int updateUserPassword(@Param("userId") Long userId, @Param("newPassword") String newPassword);

    /**
     * 修改用户token
     * @param userId
     * @param newToken
     * @return
     */
    int updateUserToken(@Param("userId") Long userId, @Param("newToken") String newToken);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int deleteBatch(Object[] ids);

    /**
     * 查询所有用户列表
     * @return
     */
    List<AdminUser> getAllAdminUsers();
}
