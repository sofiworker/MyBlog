package com.j2e.action;

import com.j2e.Constants;
import com.j2e.dto.UserDto;
import com.j2e.entities.UserBean;
import com.j2e.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import lombok.extern.log4j.Log4j2;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/5 20:40
 * @description 登录action
 */
@Component
@Log4j2
public class LoginAction extends BaseAction<UserDto> {

    private static final long serialVersionUID = 5452894593134968948L;
    private LoginService service;
    private String uid;
    private String password;

    @Autowired
    public LoginAction(LoginService service){
        this.service = service;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Action(value = "/login", results = {@Result(type = "json", name = "success", params = {"root","data"}),
            @Result(type = "json", name = "error", params = {"root", "data"})})
    public String loginAction(){
        if (validateInput()){
            if (service.findUserExist(uid)) {
                return login();
            }else {
                data.setNormalMsg("用户不存在！");
                return ERROR;
            }
        }else {
            data.setNormalMsg("输入为空/格式问题！");
            return ERROR;
        }
    }

    private String login(){
        UserBean user = service.loginSuccess(uid, password);
        if (user != null) {
            copyUserToDto(user);
            return SUCCESS;
        }else {
            data.setNormalMsg("密码错误！");
            return ERROR;
        }
    }

    private void copyUserToDto(UserBean userBean){
        UserDto dto = new UserDto();
        dto.setUid(userBean.getUid());
        dto.setUsername(userBean.getUsername());
        dto.setPhoto(userBean.getPhoto());
        dto.setGender(userBean.getGender());
        dto.setSign(userBean.getSign());
        dto.setType(userBean.getType());
        dto.setCreateTime(userBean.getCreatetime());
        data.setData(dto);
        ActionContext.getContext().getSession().put(Constants.LOGIN_USER, dto);
    }

    private boolean validateInput(){
        if (uid != null && password != null){
            return uid.length() == 11 &&
                    password.length() >= 8 && password.length() <= 16;
        }else {
            return false;
        }
    }
}
