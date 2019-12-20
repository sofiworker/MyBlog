package com.j2e.action;

import cn.hutool.core.util.StrUtil;
import com.j2e.entities.UserBean;
import com.j2e.service.change.MessageChangeService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mynameexit
 * @version 1.0.0
 * @date 2019/12/ 20:40
 * @description 修改action
 */

@Component
public class MessageAction extends BaseAction<UserBean>{

    private static final long serialVersionUID = 4433099640199934786L;
    private UserBean changemessage;
    private MessageChangeService service;

    public UserBean getChangemessage() {
        return changemessage;
    }

    public void setChangemessage(UserBean changemessage) {
        this.changemessage = changemessage;
    }

    @Autowired
    public MessageAction(MessageChangeService service){
        this.service=service;
    }

    @Action(value = "/change", interceptorRefs={@InterceptorRef("loginInterceptor")},
            results ={@Result(name = "success", type = "json", params = {"root", "data"}),
                    @Result(name = "error", type = "json", params = {"root", "data"})})
    public String change(){
        if (changemessage != null){
            service.savechange(changemessage);
            data.setNormalMsg("修改成功！");
            return SUCCESS;
        }else{
            data.setNormalMsg("修改失败！");
            return ERROR;
        }

    }

}
