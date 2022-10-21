/**
 * @author Oliver
 * @date 10/20/2022 3:58 PM
 */
package com.community.service.imp;

import com.community.dao.AdminUserDao;
import com.community.entity.AdminUser;
import com.community.service.AdminUserService;
import com.community.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminUserService")
public class AdminUserServiceImp1 implements AdminUserService {

    @Autowired
    private AdminUserDao adminUserDao;

    @Override
    public PageResult getAdminUserPage(PageUtil pageUtil) {
        // 当前页码中的数据列表
        List<AdminUser> users = adminUserDao.findAdminUsers(pageUtil);
        // 数据总条数 用于计算分页数据
        int total = adminUserDao.getTotalAdminUser(pageUtil);
        PageResult pageResult = new PageResult(users, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public AdminUser updateTokenAndLogin(String userName, String password) {
        AdminUser adminUser = adminUserDao.getAdminUserByUserNameAndPassword(userName, MD5Util.MD5Encode(password, "UTF-8"));

        if(adminUser != null) {
            // 登录后即执行修改token的操作
            String token = getNewToken(System.currentTimeMillis() + "", adminUser.getId());
            if(adminUserDao.updateUserToken(adminUser.getId(), token)>0) {
                adminUser.setUserToken(token);
                return adminUser;
            }
        }
        return null;
    }

    private String getNewToken(String sessionId, Long userId) {

        String src = sessionId + userId + NumberUtil.genRandomNum(4);
        return SystemUtil.genToken(src);

    }
}
