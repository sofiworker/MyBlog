package com.j2e.action;

import com.j2e.Constants;
import com.j2e.entities.UserBean;
import com.j2e.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/5 20:40
 * @description 用户action，包括登录与注册
 */
@Results({@Result(name = "login", type = "redirect", location = "/index.jsp"),
        @Result(name = "register", location = "/login.jsp"),
        @Result(name = "loginFail", location = "/login.jsp"),
        @Result(name = "registerFail", location = "/register.jsp")})
public class UserAction extends ActionSupport{

    private UserBean userBean;
    private LoginService mService;

    @Autowired
    public UserAction(LoginService service){
        this.mService = service;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    @Action("login")
    public String loginAction(){
        if (!validateInput()){
            String uid = userBean.getUid();
            if (mService.findUserExist(uid)) {
                UserBean user = mService.loginSuccess(userBean);
                if (user != null) {
                    ActionContext.getContext().getSession().put(Constants.LOGIN_USER, user);
                    return "login";
                }else {
                    ActionContext.getContext().put(Constants.LOGIN_FAIL, Constants.CHECK_ACCOUNT_OR_PASSWORD_RIGHT);
                    return "loginFail";
                }
            }else {
                ActionContext.getContext().put(Constants.LOGIN_FAIL, Constants.USER_NOT_EXIST_PLS_REGISTER);
                return "loginFail";
            }
        }else {
            ActionContext.getContext().put(Constants.LOGIN_FAIL, Constants.PLS_INPUT_RIGHT_FORMAT);
            return "loginFail";
        }
    }

    @Action("register")
    public String registerAction(){
        if (!validateInput()){
            String uid = userBean.getUid();
            if (mService.findUserExist(uid)) {
                ActionContext.getContext().put(Constants.REGISTER_FAIL, Constants.USER_EXIST);
                return "registerFail";
            }else {
                return "register";
            }
        }else {
            ActionContext.getContext().put(Constants.REGISTER_FAIL, Constants.PLS_INPUT_RIGHT_FORMAT);
            return "registerFail";
        }
    }

    public boolean validateInput() {
        int accountLen = 11;
        int passwordMiniLen = 8;
        int passwordMaxLen = 16;
        return userBean.getUid().length() != accountLen ||
                userBean.getPassword().length() < passwordMiniLen || userBean.getPassword().length() > passwordMaxLen;
    }
}
