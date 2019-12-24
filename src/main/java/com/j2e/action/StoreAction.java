package com.j2e.action;

import com.j2e.dto.StoreDto;
import com.j2e.service.store.StoreListService;
import com.j2e.service.store.StoreListServiceImpl;
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
 * @description 收藏action
 */

@Component
public class StoreAction extends BaseAction<List<StoreDto>> {

    private static final long serialVersionUID = -9096916428885972458L;
    private StoreListService service;

    @Autowired
    public StoreAction(StoreListService service){
        this.service=service;
    }

    @Action(value = "/mystore", interceptorRefs={@InterceptorRef("loginInterceptor")},
            results ={@Result(name = "success", type = "json", params = {"root", "data"})})
    public String myStore(){
        data.setData(service.findstore());
        return SUCCESS;
    }

}
