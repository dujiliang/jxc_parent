package com.jxc.authentication.controller;

import com.jxc.authentication.service.SessionService;
import com.jxc.common.bean.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AuthenticationController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping("/checkSession")
    public R checkSession(String token){
        return sessionService.checkSession(token);
    }

}
