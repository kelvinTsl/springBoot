package com.kelvin.common.facade;

import com.kelvin.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tangshulei on 2017/8/17.
 */
@Service("commonFacadeImpl")
public class CommonFacadeImpl implements CommonFacade{

    @Autowired
    private DemoService demoService;

    @Override
    public String helloWorld(String name) {
        demoService.testLog();
        return name + "：你好";
    }
}
