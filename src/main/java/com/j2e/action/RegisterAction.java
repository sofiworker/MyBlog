package com.j2e.action;

import cn.hutool.core.util.StrUtil;
import com.j2e.Constants;
import com.j2e.entities.UserBean;
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
 * @date 2019/12/7 23:27
 * @description 用户注册Action
 */
@Results({@Result(name = "register", location = "/login.jsp"),
        @Result(name = "registerFail", location = "/register.jsp")})
public class RegisterAction extends ActionSupport {

    private static final long serialVersionUID = -657959436584257796L;
    private UserBean userBean;
    private RegisterService mService;

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    @Autowired
    public RegisterAction(RegisterService service){
        this.mService = service;
    }

    @Action("register")
    public String registerAction(){
        if (validateInput()){
            String uid = userBean.getUid();
            if (mService.findUserExist(uid)) {
                ActionContext.getContext().put(Constants.REGISTER_FAIL, Constants.USER_EXIST);
                return "registerFail";
            }else {
                if (mService.saveUser(userBean)) {
                    return "register";
                }else {
                    return "registerFail";
                }
            }
        }else {
            ActionContext.getContext().put(Constants.REGISTER_FAIL, Constants.PLS_INPUT_RIGHT_NAME_FORMAT);
            return "registerFail";
        }
    }

    public boolean validateInput() {
        int accountLen = 11;
        int passwordMiniLen = 8;
        int passwordMaxLen = 16;
        return userBean.getUid().length() == accountLen && !StrUtil.isEmpty(userBean.getUsername()) &&
                userBean.getPassword().length() >= passwordMiniLen && userBean.getPassword().length() <= passwordMaxLen;
    }
}
