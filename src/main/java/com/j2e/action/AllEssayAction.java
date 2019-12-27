package com.j2e.action;

import cn.hutool.core.util.PageUtil;
import com.j2e.dto.EssayDto;
import com.j2e.entities.EssayBean;
import com.j2e.service.essay.EssayService;
import lombok.extern.log4j.Log4j2;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Log4j2
public class AllEssayAction extends BaseAction<List<EssayDto>> {

    private static final long serialVersionUID = -8094575007343137422L;
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
