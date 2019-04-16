package com.jxc.short_message.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.jxc.common.bean.R;
import com.jxc.common.exception.RequestParamException;
import com.jxc.common.util.S;
import com.jxc.short_message.constant.ShortMsgConst;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@Component
public class SendRegisterMsg extends ShortMessageServiceImpl {

    private String actionCode = "1";

    public SendRegisterMsg() {
        ShortMsgConst.actionMap.put(actionCode, this);
    }

    @Override
    public String msgFor() {
        return "注册";
    }

    @Override
    protected Map<String, String> getOtherParam(HttpServletRequest req) throws Exception{
        String expir = req.getParameter("expir");
        String client = req.getParameter("client");
        String confirmCode = req.getParameter("confirmCode");

        if (S.isEmpty(expir)) {
            throw new RequestParamException("有效时间不能为空");
        }

        if (!S.isInt(expir)) {
            throw new RequestParamException("有效时间格式不正确");
        }

        if (S.isEmpty(confirmCode)) {
            throw new RequestParamException("验证码不能为空");
        }

        if(!client.matches("1|2")){
            throw new RequestParamException("客户端编号无效");
        }

        return new HashMap<String, String>() {{
            put("expir", expir);
            put("confirmCode", confirmCode);
            put("client", client);
        }};
    }


    public String initMessage(Map<String, String> otherParam) {

        int minute = Integer.parseInt(String.valueOf(otherParam.get("expir")))/60;
        String confirmCode = otherParam.get("confirmCode");

        String clientName = "";
        switch (otherParam.get("client")){
            case "1":{
                clientName = "机主版";
                break;
            }
            case "2":{
                clientName = "承租方版";
                break;
            }
            default:break;
        }

        String msg = "您正在执行" + clientName + msgFor() + "操作，需要进行校验，验证码" + confirmCode + "，有效时间" + minute + "分钟，请勿向任何人提供此校验码。【喂喂打工】";

        return msg;
    }

    @Override
    public R sendMessage(String phone , String client , HttpServletRequest req){

        MultivaluedMapImpl formData = new MultivaluedMapImpl();
        try {
            String message = initMessage(getOtherParam(req));

            formData.add("mobile", phone);
            formData.add("message", message);

//            String jerseyResultStr = jerseyUtil.send(formData);
//            JSONObject jsonObject = JSONObject.parseObject(jerseyResultStr);

            String error = "0";

//            String error = jsonObject.getString("error");
            if (error.equals("0")) {
                msgLoggerDao.insert(phone, actionCode ,client, message);
            }

        }catch (Exception e){
            if(e instanceof RequestParamException){
                return R.error(10,e.getMessage());
            }else{
                return R.error(-1,e.getMessage());
            }
        }

        return R.ok();
    }
}
