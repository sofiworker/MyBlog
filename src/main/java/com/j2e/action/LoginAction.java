package com.j2e.action;

import com.j2e.Constants;
import com.j2e.entities.UserBean;
import com.j2e.service.LoginService;
import com.j2e.service.RegisterService;
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
        @Result(name = "loginFail", location = "/login.jsp")})
public class LoginAction extends ActionSupport{

    private static final long serialVersionUID = 5452894593134968948L;
    private UserBean userBean;
    private LoginService mLogin;

    @Autowired
    public LoginAction(LoginService service){
        this.mLogin = service;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    @Action("login")
    public String loginAction(){
        if (validateInput()){
            String uid = userBean.getUid();
            if (mLogin.findUserExist(uid)) {
                UserBean user = mLogin.loginSuccess(userBean);
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

    public boolean validateInput() {
        int accountLen = 11;
        int passwordMiniLen = 8;
        int passwordMaxLen = 16;
        return userBean.getUid().length() == accountLen &&
                userBean.getPassword().length() >= passwordMiniLen && userBean.getPassword().length() <= passwordMaxLen;
    }
}
