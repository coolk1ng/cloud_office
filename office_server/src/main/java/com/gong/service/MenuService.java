package com.gong.service;

import com.gong.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CodeSniper
 * @since 2021-08-28
 */
public interface MenuService extends IService<Menu> {

    /**
     * 根据用户id获取菜单列表
     * @return List<Menu>
     */
    List<Menu> getMenusByAdminId();

    /**
     * 通过角色获取菜单列表
     * @return List<Menu>
     */
    List<Menu> getMenusByRoles();

    /**
     * 获取所有菜单
     * @return List<Menu>
     */
    List<Menu> getAllMenus();
}
