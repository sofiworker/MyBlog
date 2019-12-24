package com.j2e.interceptor;

import com.j2e.Constants;
import com.j2e.dto.UserDto;
import com.j2e.entities.UserBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import lombok.extern.log4j.Log4j2;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/9 9:40
 * @description 请求拦截器
 */
@Log4j2
public class LoginInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = -5048685344067535232L;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
//        Object action = invocation.getAction();
//        log.debug(action.getClass().getSimpleName());
        UserDto user = (UserDto) ActionContext.getContext().getSession().get(Constants.LOGIN_USER);
        if (user == null) {
            return "noLogin";
        }else {
            return invocation.invoke();
        }
    }
}
