package com.jxc.short_message.service;

import com.jxc.common.bean.R;

import javax.servlet.http.HttpServletRequest;

public interface ShortMessageService {

    public R sendMessage(String phone ,String client ,HttpServletRequest req);

    public String msgFor();

}
