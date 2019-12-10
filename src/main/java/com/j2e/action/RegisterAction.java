package com.j2e.action;

import cn.hutool.core.util.StrUtil;
import com.j2e.entities.UserBean;
import com.j2e.service.RegisterService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/7 23:27
 * @description 用户注册Action
 */
@Component
public class RegisterAction extends BaseAction<UserBean> {

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

    @Action(value = "/register", results = {@Result(name = "register", type = "json", params = {"root", "data"}),
            @Result(name = "registerFail", type = "json", params = {"root", "data"})})
    public String registerAction(){
        if (validateInput()){
            String uid = userBean.getUid();
            if (mService.findUserExist(uid)) {
                data.setNormalMsg("用户已存在！");
                return "registerFail";
            }else {
                return register();
            }
        }else {
            data.setNormalMsg("输入格式出错！");
            return "registerFail";
        }
    }

    private String register(){
        if (mService.saveUser(userBean)) {
            data.setNormalMsg("注册成功！");
            return "register";
        }else {
            data.setNormalMsg("注册失败！");
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
