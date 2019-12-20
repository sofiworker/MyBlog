package com.j2e.action;



import com.j2e.entities.UserBean;
import com.j2e.service.message.UserMessageService;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.springframework.stereotype.Component;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author mynameexit
 * @version 1.0.0
 * @date 2019/12/ 20:40
 * @description 显示action
 */

@Component
public class UserMessageAction extends BaseAction<UserBean>{
    private static final long serialVersionUID = -6286431390186226066L;
    private UserMessageService umservice;

    @Autowired
    public UserMessageAction(UserMessageService umservice){
        this.umservice=umservice;
    }

    @Action(value = "/usermessage",
            interceptorRefs = {@InterceptorRef("loginInterceptor")},
            results = {@Result(type = "json", name = "success", params = {"root","data"}),
            })
    public String usermessage(){
        UserBean user=umservice.usermesssage();
        data.setData(user);
        return SUCCESS;
    }
}
