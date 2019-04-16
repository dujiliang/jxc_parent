package com.jxc.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jxc.common.bean.R;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Io {

    public static void preForOut(R r, HttpServletResponse resp){
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        try {
            resp.getWriter().write(JSON.toJSONString(r, SerializerFeature.WriteMapNullValue));
            resp.flushBuffer();
        } catch (IOException e) {

        }
    }

    public static void aspectOut(R r, HttpServletResponse resp){

        resp.reset();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        try {
            ServletOutputStream out = resp.getOutputStream ();
            out.write (JSON.toJSONString(r, SerializerFeature.WriteMapNullValue).getBytes());
            out.close();

//            resp.flushBuffer();
        } catch (IOException e) {

        }
    }

}
