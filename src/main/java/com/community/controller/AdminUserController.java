/**
 * @author Oliver
 * @date 10/20/2022 4:00 PM
 */
package com.community.controller;

import com.community.common.Constants;
import com.community.common.Result;
import com.community.common.ResultGenerator;
import com.community.service.AdminUserService;
import com.community.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 列表
     * @param params
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result list(@RequestParam Map<String, Object> params) {

        if(StringUtils.isEmpty(params.get("page"))|| StringUtils.isEmpty(params.get("limit")))
        {
            return ResultGenerator.genErrorResult(Constants.RESULT_CODE_PARAM_ERROR, "参数异常^^!");
        }

        // 查询列表数据
        PageUtil pageUtil = new PageUtil(params);
        return ResultGenerator.genSuccessResult(adminUserService.getAdminUserPage(pageUtil));
    }

}
