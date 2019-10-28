package com.jerry.springboot_jedis.base.controller;

import com.jerry.springboot_jedis.base.utils.StateParameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;

import java.sql.Statement;
import java.util.UUID;


public abstract class BaseController {
    protected final String success= StateParameter.SUCCESS;
    protected final String fail=StateParameter.FAULT;
    public ModelMap getModelMap(String status,Object data,String msg)
    {
        ModelMap modelMap=new ModelMap();
        modelMap.put("status",status);
        modelMap.put("data",data);
        modelMap.put("msg",msg);
        return modelMap;
    }
    public String getUuid()
    {
        String uuid= UUID.randomUUID().toString();
        uuid=uuid.replace("-","");
        return uuid;
    }
}
