package com.kelvin.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created by tangshulei on 2017/9/28.
 */
//@WebFilter(filterName = "druidStatFilter",urlPatterns = "/*",
//initParams = {
//        @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")// 忽略资源
//})
public class DruidStatFilter extends WebStatFilter{

}
