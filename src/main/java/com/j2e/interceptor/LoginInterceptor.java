package com.j2e.interceptor;

import com.alibaba.fastjson.JSON;
import com.j2e.Constants;
import com.j2e.dto.UserDto;
import com.j2e.entities.BaseData;
import com.j2e.entities.UserBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import lombok.extern.log4j.Log4j2;
import org.apache.struts2.ServletActionContext;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/9 9:40
 * @description 请求拦截器
 */
@Log4j2
public class LoginInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 4468663570485995372L;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        UserDto user = (UserDto) ActionContext.getContext().getSession().get(Constants.LOGIN_USER);
        if (user == null) {
            ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
            ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
            BaseData data = new BaseData();
            data.setNormalMsg("未登录！");
            ServletActionContext.getResponse().getWriter().print(JSON.toJSONString(data));
            return null;
        }else {
            return invocation.invoke();
        }
    }
}
