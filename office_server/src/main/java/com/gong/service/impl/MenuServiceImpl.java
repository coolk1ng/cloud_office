package com.gong.service.impl;

import com.gong.pojo.Admin;
import com.gong.pojo.Menu;
import com.gong.mapper.MenuMapper;
import com.gong.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author CodeSniper
 * @since 2021-08-28
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 根据用户id获取菜单列表
     * @return List<Menu>
     */
    @Override
    public List<Menu> getMenusByAdminId() {
        Integer id = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        //从redis获取菜单数据
        List<Menu> menus = (List<Menu>) valueOperations.get("menu_" + id);
        //如果为空,去数据库获取
        if (CollectionUtils.isEmpty(menus)) {
            menus = menuMapper.getMenusByAdminId(id);
            //将数据设置到redis中
            valueOperations.set("menu_"+id,menus);
        }
        return menus;
    }

    /**
     * 通过角色获取菜单列表
     * @return List<Menu>
     */
    @Override
    public List<Menu> getMenusByRoles() {
        return menuMapper.getMenuByRoles();
    }
}
