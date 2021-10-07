package com.gong.mapper;

import com.gong.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CodeSniper
 * @since 2021-08-28
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据用户获取菜单列表
     * @param id
     * @return List<Menu>
     */
    List<Menu> getMenusByAdminId(Integer id);

    /**
     * 通过角色获取菜单列表
     * @return List<Menu>
     */
    List<Menu> getMenuByRoles();

    /**
     * 获取所有菜单
     * @return List<Menu>
     */
    List<Menu> getAllMenus();
}
