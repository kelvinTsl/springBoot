package com.kelvin.controller;

import com.kelvin.service.DemoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangshulei on 2017/9/28.
 */
@RestController
public class indexController{

    @Autowired
    private DemoServiceImpl demoService;

    @RequestMapping("/a/{name}")
    public String index(@PathVariable String name){
        demoService.testLog();
        return "123";
    }
}
