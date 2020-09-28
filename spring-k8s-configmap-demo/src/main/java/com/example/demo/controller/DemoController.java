package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring-boot 调用配置文件 Controller
 */
@RestController
@RequestMapping("/demo")
@PropertySource("classpath:mysql.properties")
@Api(tags = "DemoController", description = "测试读取不同资源文件")
public class DemoController {
	
	private Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Value("${env}")
    private String env;
    
    @Value("${msg}")
    private String msg;
    
    @Value("${mysql.hostname}")
    private String mysql_url;
    
    @Value("${mysql.port}")
    private String mysql_port;

    @ApiOperation(value = "获取配置文件变量")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, Object> getDemoKey() {
        Map<String, Object> map = new HashMap<>();
        try {
            map.put("env", env);
            map.put("msg", msg);
            map.put("mysql_url", mysql_url);
            map.put("mysql_port", mysql_port);
            logger.info("获取配置文件变量：");
            logger.info("env: "+env);
            logger.info("msg: "+msg);
            logger.info("mysql_url: "+mysql_url);
            logger.info("mysql_port: "+mysql_port);           
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("发生异常了", e);
        }
        return map;
    }

}
