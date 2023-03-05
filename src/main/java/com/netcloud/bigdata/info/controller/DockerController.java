package com.netcloud.bigdata.info.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author netcloud
 * @date 2023-03-05 21:41:54
 * @email netcloudtec@163.com
 * @description
 */
@RestController
public class DockerController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/docker")
    public String helloDocker()
    {
        return "hello docker"+"\t"+port+"\t"+ UUID.randomUUID().toString();
    }

}
