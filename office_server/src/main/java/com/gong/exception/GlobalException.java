package com.gong.exception;


import com.gong.utils.ResultBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理
 * 
 * @author CodeSniper
 * @since 2021-10-07
 */
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLException.class)
    public ResultBean SQLException(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return ResultBean.error("该数据有关联数据,操作失败!");
        }
        return ResultBean.error("数据库异常,操作失败!");
    }
}
