package com.kelvin.service;

import com.kelvin.entity.SysConfig;
import com.kelvin.mapper.SysConfigMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tangshulei on 2017/8/17.
 */
@Service
public class DemoServiceImpl implements DemoService{
    Logger logger = LogManager.getLogger(DemoServiceImpl.class);

    @Autowired
    private SysConfigMapper sysConfigMapper;

    public void testLog(){
        List<SysConfig> list = sysConfigMapper.selectAll();
        SysConfig sysConfig = sysConfigMapper.selectById(1);
        System.out.println(list.size());
        logger.info("这是 info 信息");
        logger.debug("这是 debug 信息");
        logger.warn("这是 warn 信息");
        logger.error("这是 error 信息");
    }
}
