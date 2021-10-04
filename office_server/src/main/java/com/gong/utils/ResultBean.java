package com.gong.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共返回对象
 * 
 * @author CodeSniper
 * @since 2021-09-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean {
    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回结果
     * @param message
     * @return ResultBean
     * @since 2021/9/5
     */
    public static ResultBean success(String message){
        return new ResultBean(200,message,null);
    }

    /**
     * 成功返回对象
     * @param message
     * @param obj
     * @return ResultBean
     * @since 2021/9/5
     */
    public static ResultBean success(String message,Object obj){
        return new ResultBean(200,message,obj);
    }

    /**
     * 失败返回结果
     * @param message
     * @return ResultBean
     * @since 2021/9/5
     */
    public static ResultBean error(String message){
        return new ResultBean(500,message,null);
    }

    /**
     * 失败返回结果
     * @param message
     * @param obj
     * @return ResultBean
     * @since 2021/9/5
     */
    public static ResultBean error(String message,Object obj){
        return new ResultBean(500,message,obj);
    }
}
