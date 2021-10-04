package com.gong.controller;


import com.gong.pojo.Position;
import com.gong.service.PositionService;
import com.gong.utils.ResultBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CodeSniper
 * @since 2021-08-28
 */
@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @ApiOperation(value = "获取所有职位信息")
    @GetMapping("/")
    public List<Position> getPosition(){
        return positionService.list();
    }

    @ApiOperation(value = "添加职位信息")
    @PostMapping("/")
    public ResultBean addPosition(@RequestBody Position position){
        position.setCreateDate(new Date());
        if (positionService.save(position)){
            return ResultBean.success("添加成功!");
        }else{
            return ResultBean.error("添加失败!");
        }
    }

    @ApiOperation(value = "更新职位信息")
    @PostMapping("/")
    public ResultBean updatePosition(@RequestBody Position position){
        if (positionService.updateById(position)){
            return ResultBean.success("更新成功!");
        }else{
            return ResultBean.error("更新失败!");
        }
    }

    @ApiOperation(value = "删除职位信息")
    @DeleteMapping("/{id}")
    public ResultBean deletePositionById(@PathVariable Integer id){
        if (positionService.removeById(id)){
            return ResultBean.success("删除成功!");
        }else {
            return ResultBean.error("删除失败!");
        }
    }

    @ApiOperation(value = "批量删除职位信息")
    @DeleteMapping("/")
    public ResultBean deletePositionByIds(Integer[] ids){
        if (positionService.removeByIds(Arrays.asList(ids))){
            return ResultBean.success("批量删除成功!");
        }else {
            return ResultBean.error("批量删除失败!");
        }
    }
}
