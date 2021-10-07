package com.gong.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gong.pojo.Menu;
import com.gong.pojo.MenuRole;
import com.gong.pojo.Role;
import com.gong.service.MenuRoleService;
import com.gong.service.MenuService;
import com.gong.service.RoleService;
import com.gong.utils.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.DeleteProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限组
 * 
 * @author CodeSniper
 * @since 2021-10-07
 */
@RestController
@Api(tags = "角色管理")
@RequestMapping("/system/basic/permission")
public class PermissionController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuRoleService menuRoleService;

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/getAllPermission")
    public List<Role> getAllPermission(){
        return roleService.list();
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/addPermission")
    public ResultBean addPermission(@RequestBody Role role){
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        if (roleService.save(role)){
            return ResultBean.success("添加成功!");
        }else{
            return ResultBean.error("添加失败!");
        }
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/deletePermission/{rid}")
    public ResultBean deletePermission(@PathVariable Integer rid){
        if (roleService.removeById(rid)){
            return ResultBean.success("删除成功!");
        }else{
            return ResultBean.error("删除失败!");
        }
    }

    @ApiOperation(value = "获取所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    @ApiOperation(value = "根据角色id查询菜单id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidByRid(@PathVariable Integer rid){
        return menuRoleService.list(new QueryWrapper<MenuRole>().eq("rid",rid))
                .stream().map(MenuRole::getMid).collect(Collectors.toList());
    }
}
