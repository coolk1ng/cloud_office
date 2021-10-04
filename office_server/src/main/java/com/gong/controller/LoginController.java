package com.gong.controller;



import com.gong.mapper.RoleMapper;
import com.gong.pojo.Admin;
import com.gong.pojo.AdminLoginParam;
import com.gong.service.AdminService;
import com.gong.utils.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * 登录
 *
 * @author CodeSniper
 * @since 2021-09-05
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleMapper roleMapper;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public ResultBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request) {
        ResultBean login = adminService.login(adminLoginParam.getUsername(), adminLoginParam.getPassword(), adminLoginParam.getCode(), request);
        return login;
    }

    @ApiOperation(value = "获取当前用户信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal) {
        if (principal == null) {
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
        admin.setRoles(roleMapper.getRoles(admin.getId()));
        return admin;
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public ResultBean logout() {
        return ResultBean.success("注销成功");
    }
}
