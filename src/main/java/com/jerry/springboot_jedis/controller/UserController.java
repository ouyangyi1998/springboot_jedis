package com.jerry.springboot_jedis.controller;

import com.jerry.springboot_jedis.base.controller.BaseController;
import com.jerry.springboot_jedis.base.utils.RedisConstants;
import com.jerry.springboot_jedis.base.utils.RedisUtil;
import com.jerry.springboot_jedis.base.utils.SerializeUtil;
import com.jerry.springboot_jedis.base.utils.StateParameter;
import com.jerry.springboot_jedis.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController extends BaseController {
    @Autowired
    RedisUtil redisUtil;
    @RequestMapping(value = "getRedis",method = RequestMethod.POST)
    public ModelMap getRedis()
    {
        redisUtil.set("key1","redis_go", RedisConstants.datebase1);
        Long resExpire=redisUtil.expire("key1",60,RedisConstants.datebase1);
        log.info("resExpire="+resExpire);
        String res=redisUtil.get("key1",RedisConstants.datebase1);



        User u=new User();
        u.setAge(24);
        u.setName("jerry");
        redisUtil.set("key2".getBytes(), SerializeUtil.serialize(u),RedisConstants.datebase1);
        byte[] user=redisUtil.get("key2".getBytes(),RedisConstants.datebase1);
        User user1=(User)SerializeUtil.unserialize(user);
        System.out.println("user="+user1.toString());
        return getModelMap(StateParameter.SUCCESS,res,"success");
    }

}
