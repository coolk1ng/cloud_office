package com.gong.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * 
 * @author CodeSniper
 * @since 2021-09-07
 */
@RestController
public class TestController {

    @GetMapping
    public String hello(){
        return "hello";
    }
}
