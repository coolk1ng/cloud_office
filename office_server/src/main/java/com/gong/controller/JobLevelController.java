package com.gong.controller;


import com.gong.pojo.JobLevel;
import com.gong.service.JobLevelService;
import com.gong.utils.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CodeSniper
 * @since 2021-08-28
 */
@RestController
@RequestMapping("/system/basic/jobLevel")
@Api(tags = "职称管理")
public class JobLevelController {

    @Autowired
    private JobLevelService jobLevelService;

    @ApiOperation(value = "获取所有职称信息")
    @GetMapping("/getAllJobLevel")
    public List<JobLevel> getAllJobLevel() {
        return jobLevelService.list();
    }

    @ApiOperation(value = "添加职称信息")
    @PostMapping("/addJobLevel")
    public ResultBean addJobLevel(@RequestBody JobLevel jobLevel) {
        jobLevel.setCreateDate(new Date());
        if (jobLevelService.save(jobLevel)) {
            return ResultBean.success("添加成功!");
        } else {
            return ResultBean.error("添加失败!");
        }
    }

    @ApiOperation(value = "更新职称信息")
    @PutMapping("/updateJobLevel")
    public ResultBean updateJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateById(jobLevel)) {
            return ResultBean.success("更新成功!");
        } else {
            return ResultBean.error("更新失败!");
        }
    }

    @ApiOperation(value = "删除职称信息")
    @DeleteMapping("/deleteJobLevelById/{id}")
    public ResultBean deleteJobLevel(@PathVariable Integer id){
        if (jobLevelService.removeById(id)){
            return ResultBean.success("删除成功!");
        }else{
            return ResultBean.error("删除失败!");
        }
    }

    @ApiOperation(value = "批量删除职称信息")
    @DeleteMapping("/deleteJobLevelByIds")
    public ResultBean deleteJobLevelByIds(Integer[] ids){
        if (jobLevelService.removeByIds(Arrays.asList(ids))){
            return ResultBean.success("批量删除成功!");
        }else{
            return ResultBean.error("批量删除失败!");
        }
    }
}
