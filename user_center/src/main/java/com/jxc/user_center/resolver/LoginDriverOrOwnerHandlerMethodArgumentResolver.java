package com.jxc.user_center.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.jxc.common.annotation.AllPermissionUser;
import com.jxc.common.annotation.DriverOrOwnerUser;
import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.constants.SessionConstants;

/**
 * 有@AllPermissionUser注解的方法参数，注入当前登录承租方
 */
@Component
public class LoginDriverOrOwnerHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(AuthorizationUser.class) && parameter.hasParameterAnnotation(DriverOrOwnerUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {
    	
//        //获取用户ID
        String userId = (String) request.getAttribute(SessionConstants.USER_ID_DRIVER_OR_OWNER, RequestAttributes.SCOPE_REQUEST);
        
        String roleId = (String) request.getAttribute(SessionConstants.ROLE_TYPE_DRIVER_OR_OWNER, RequestAttributes.SCOPE_REQUEST);
        
        AuthorizationUser user = new AuthorizationUser();
        user.setUserId(Long.valueOf(userId));
        user.setRoleType(Integer.valueOf(roleId));
        return user;
    }
}
