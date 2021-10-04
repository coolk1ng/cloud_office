package com.gong.service;

import com.gong.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gong.pojo.Role;
import com.gong.utils.ResultBean;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CodeSniper
 * @since 2021-08-28
 */
public interface AdminService extends IService<Admin> {
    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return ResultBean
     * @since 2021/9/5
     */
    ResultBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     * @param username
     * @return Admin
     * @since 2021/9/5
     */
    Admin getAdminByUserName(String username);

    /**
     * 根据用户id获取权限列表
     * @param adminId
     * @return List<Role>
     */
    List<Role> getRoles(Integer adminId);
}
