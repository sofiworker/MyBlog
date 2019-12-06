package com.j2e.action;

import com.j2e.entities.UserBean;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/5 20:40
 * @description 登录action
 */

@Action("login")
@Result(location = "")
public class LoginAction extends ActionSupport {

    private UserBean userBean;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }
}
