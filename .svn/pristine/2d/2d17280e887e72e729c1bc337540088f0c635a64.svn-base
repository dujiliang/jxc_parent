package com.jxc.authentication.service.impl;

import com.jxc.common.bean.R;
import com.jxc.authentication.service.SessionService;
import com.jxc.common.constants.RedisConstantsForRegist;
import com.jxc.common.exception.RedisConnectionFailureError;
import com.jxc.common.util.RedisUtil;
import com.jxc.common.util.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SessionServiceImpl implements SessionService{

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public R checkSession(String token) {

        if(S.isEmpty(token)){
            return R.error(1,"token不能为空");
        }

        String key = RedisConstantsForRegist.REDIS_TOKEN_LOGIN_PREFIX + token;

        try {

            if(redisUtil.hasKey(key) == false){
                return R.error(2,"无效token");
            }

            Map<String,String> map = redisUtil.hGetAll(key);
            return R.ok(new HashMap<String,Object>(){{
                put("session",map);
            }});
        }catch (Exception e){
            if(e instanceof RedisConnectionFailureError){
                return R.error(10,"redis服务连接失败");
            }
        }

        return R.error(-1,"");

    }
}
