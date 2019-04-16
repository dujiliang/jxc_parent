package com.jxc.employment_center.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.jxc.common.annotation.Child;
import com.jxc.common.bean.AuthorizationUser;
import com.jxc.common.constants.SessionConstants;

/**
 * 有@Child注解的方法参数，注入当前登录用户
 */
@Component
public class LoginChildHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(AuthorizationUser.class) && parameter.hasParameterAnnotation(Child.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {
    	
//        //获取用户ID
        String userId = (String) request.getAttribute(SessionConstants.USER_ID_CHILD, RequestAttributes.SCOPE_REQUEST);
        
        String roleId = (String) request.getAttribute(SessionConstants.ROLE_TYPE_CHILD, RequestAttributes.SCOPE_REQUEST);
        
        AuthorizationUser user = new AuthorizationUser();
        user.setUserId(Long.valueOf(userId));
        user.setRoleType(Integer.valueOf(roleId));
        return user;
    }
}
