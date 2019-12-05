package com.j2e;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/5 20:40
 * @description 登录action
 */

@Action
@Result(location = "/login.jsp")
public class LoginAction extends ActionSupport {

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
