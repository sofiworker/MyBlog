package com.j2e.action;

import com.j2e.Constants;
import com.j2e.entities.UserBean;
import com.j2e.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/5 20:40
 * @description 用户action，包括登录与注册
 */
@Component
public class LoginAction extends BaseAction<UserBean> {

    private static final long serialVersionUID = 5452894593134968948L;
    private UserBean userBean;
    private LoginService service;

    @Autowired
    public LoginAction(LoginService service){
        this.service = service;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    @Action(value = "/login", results = {@Result(type = "json", name = "success", params = {"root","data"}),
            @Result(type = "json", name = "error", params = {"root", "data"})})
    public String loginAction(){
        if (validateInput()){
            String uid = userBean.getUid();
            if (service.findUserExist(uid)) {
                return login();
            }else {
                data.setNormalMsg("用户不存在！");
                return ERROR;
            }
        }else {
            data.setNormalMsg("输入格式问题！");
            return ERROR;
        }
    }

    private String login(){
        UserBean user = service.loginSuccess(userBean);
        if (user != null) {
            user.setPassword(null);
            data.setData(user);
            ActionContext.getContext().getSession().put(Constants.LOGIN_USER, user);
            return SUCCESS;
        }else {
            data.setNormalMsg("登录失败！");
            return ERROR;
        }
    }

    public boolean validateInput() {
        int accountLen = 11;
        int passwordMiniLen = 8;
        int passwordMaxLen = 16;
        return userBean.getUid().length() == accountLen &&
                userBean.getPassword().length() >= passwordMiniLen && userBean.getPassword().length() <= passwordMaxLen;
    }
}
