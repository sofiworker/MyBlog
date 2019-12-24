package com.j2e.action;

import com.j2e.Constants;
import com.j2e.dto.UserDto;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/24 17:54
 * @description 登出接口
 */
public class LogoutAction extends BaseAction<String> {

    private static final long serialVersionUID = 1276242514261532087L;

    @Action(value = "/logout", results = {@Result(type = "json", name = "success", params = {"root","data"}),
            @Result(type = "json", name = "error", params = {"root", "data"})})
    public String allEssay(){
        UserDto dto = (UserDto) ActionContext.getContext().getSession().get(Constants.LOGIN_USER);
        if (dto != null) {
            ActionContext.getContext().getSession().clear();
            data.setData(null);
            return SUCCESS;
        }else {
            data.setMsg("退出失败！");
            data.setData(null);
            return ERROR;
        }
    }
}
