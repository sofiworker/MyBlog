package com.j2e.action;

import com.j2e.dto.EssayDto;
import com.j2e.entities.EssayBean;
import com.j2e.service.essay.EssayService;
import lombok.extern.log4j.Log4j2;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Log4j2
public class SearchEssayAction extends BaseAction<List<EssayDto>> {

    private static final long serialVersionUID = 5452894593134968948L;
    private EssayService service;
    private String str;
    public void setStr(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    @Autowired
    public SearchEssayAction(EssayService service){
        this.service = service;
    }


    @Action(value = "/SearchEssay", results = {@Result(type = "json", name = "success", params = {"root","data"}),
            @Result(type = "json", name = "error", params = {"root", "data"})})
    public String search(){
        data.setData(service.searchEssay(str));
        return SUCCESS;
    }
}