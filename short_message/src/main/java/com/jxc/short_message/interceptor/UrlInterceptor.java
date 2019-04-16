package com.jxc.short_message.interceptor;

import com.jxc.common.bean.R;
import com.jxc.common.util.IPAddressUtil;
import com.jxc.common.util.Io;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UrlInterceptor implements HandlerInterceptor{

//    List<String> whiteIPList = new ArrayList<String>(){{
//        add("127.0.0.1");
//        add("192.168.0.239");
//    }};

    //在请求处理之前进行调用（Controller方法调用之前）
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String ip = IPAddressUtil.getRealIP(httpServletRequest);

        String logStr = "===============来自" + ip + "的访问";

        if(ip.equals("127.0.0.1")){
            System.out.println(logStr);
            return true;
        }else{
            if(ip.startsWith("192.168.0.")){
                System.out.println(logStr);
                return true;
            }else{
                System.out.println(logStr + "--->已拦截");
                Io.preForOut(R.error(500,"ip被拦截"),httpServletResponse);
                return false;
            }
        }
    }

    //请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    //在整个请求结束之后被调用
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }



}
