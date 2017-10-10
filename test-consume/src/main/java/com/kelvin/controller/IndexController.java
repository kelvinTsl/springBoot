package com.kelvin.controller;

import com.kelvin.common.facade.CommonFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangshulei on 2017/8/17.
 */
@RestController
public class IndexController {

    @Autowired
    private CommonFacade commonFacade;

    @RequestMapping("/{name}")
    public String index(@PathVariable String name){
        return commonFacade.helloWorld(name);
//        return "123";
    }
}
