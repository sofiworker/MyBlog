package com.j2e.action;

import com.j2e.entities.BaseData;
import com.j2e.entities.TagBean;
import com.j2e.service.tag.TagService;
import com.opensymphony.xwork2.ActionSupport;
import lombok.extern.log4j.Log4j2;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/14 22:12
 * @description 文章查询tag的action
 */
@Controller
@ParentPackage("com.j2e")
public class TagAction extends ActionSupport {

    private static final long serialVersionUID = 1358050148613013698L;
    private TagService service;
    private BaseData<List<TagBean>> data = new BaseData<>();

    public BaseData<List<TagBean>> getData() {
        return data;
    }

    public void setData(BaseData<List<TagBean>> data) {
        this.data = data;
    }

    @Autowired
    public TagAction(TagService service){
        this.service = service;
    }

//    interceptorRefs = {@InterceptorRef("loginInterceptor")},
    @Action(value = "/tagList",
            results ={@Result(name = "success", type = "json", params = {"root", "data"}),
                    @Result(name = "error", type = "json", params = {"root", "data"})})
    public String searchTag(){
        List<TagBean> tags = service.findTags();
        data.setData(tags);
        return SUCCESS;
    }
}
