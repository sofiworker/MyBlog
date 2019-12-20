package com.j2e.action;

import com.j2e.Constants;
import com.j2e.dto.UserDto;
import com.j2e.entities.EssayBean;
import com.j2e.entities.UserBean;
import com.j2e.service.essay.EssayService;
import com.j2e.service.login.LoginService;
import com.opensymphony.xwork2.ActionContext;
import lombok.extern.log4j.Log4j2;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class AllEssayAction extends BaseAction<List<EssayBean>> {

    private static final long serialVersionUID = 5452894593134968948L;
    private EssayService service;

    @Autowired
    public AllEssayAction(EssayService service){
        this.service = service;
    }


    @Action(value = "/AllEssay", results = {@Result(type = "json", name = "success", params = {"root","data"}),
            @Result(type = "json", name = "error", params = {"root", "data"})})
    public String allEssay(){
        data.setData(service.AllEssay());
        return SUCCESS;
    }
}
