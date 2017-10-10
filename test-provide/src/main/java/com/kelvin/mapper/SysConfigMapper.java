package com.kelvin.mapper;

import com.kelvin.entity.SysConfig;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by tangshulei on 2017/9/28.
 */
public interface SysConfigMapper {

    @Results(id="sysConfigs",value= {
            @Result(column = "config_key", property = "configKey"),
            @Result(column = "config_value", property = "configValue"),
            @Result(column = "date_start", property = "dateStart"),
            @Result(column = "date_end", property = "dateEnd"),
            @Result(column = "date_created", property = "dateCreated"),
            @Result(column = "created_by", property = "createdBy"),
            @Result(column = "date_updated", property = "dateUpdated"),
            @Result(column = "updated_by", property = "updatedBy"),
    })
    @Select("select * from sys_config")
    List<SysConfig> selectAll();

    @ResultMap(value = "sysConfigs")
    @Select("select * from sys_config where id = #{id}")
    SysConfig selectById(Integer id);
}
