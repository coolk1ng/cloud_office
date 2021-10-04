package com.gong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * springboot启动类
 *
 * @author CodeSniper
 * @since 2021-08-28
 */

@SpringBootApplication
@MapperScan("com.gong.mapper")
public class OfficeServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OfficeServerApplication.class,args);
    }
}
