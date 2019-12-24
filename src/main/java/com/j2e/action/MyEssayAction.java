package com.j2e.action;


import com.j2e.dto.MyEassyItemDto;
import com.j2e.service.myeassy.MyEssayService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author mynameexit
 * @version 1.0.0
 * @date 2019/12/ 20:40
 * @description 查看我的文章action
 */

@Component
public class MyEssayAction extends BaseAction<List<MyEassyItemDto>>{

    private static final long serialVersionUID = 7669890634755728250L;

    private MyEssayService service;

    @Autowired
    public MyEssayAction(MyEssayService service){
        this.service=service;
    }

    @Action(value = "/myessay", interceptorRefs={@InterceptorRef("loginInterceptor")},
            results ={@Result(name = "success", type = "json", params = {"root", "data"}),
                    @Result(name = "error", type = "json", params = {"root", "data"})})
    public String myessay(){
        data.setData(service.myeassy());
        return SUCCESS;
    }
}
