/**
 * @author Oliver
 * @date 10/20/2022 5:32 PM
 */
package com.community.service;

import com.community.entity.AdminUser;
import com.community.utils.PageResult;
import com.community.utils.PageUtil;

public interface AdminUserService {

    /**
     * 分页功能
     * @param pageUtil
     * @return
     */
    PageResult getAdminUserPage(PageUtil pageUtil) ;

    /**
     * 登录功能
     * @param userName
     * @param password
     * @return
     */
    AdminUser updateTokenAndLogin(String userName, String password);



}
