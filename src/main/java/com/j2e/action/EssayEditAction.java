package com.j2e.action;

import com.j2e.entities.EssayBean;
import com.j2e.service.essay.EssayService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/9 18:11
 * @description 编写文章的action
 */
@Controller
public class EssayEditAction extends BaseAction<String> {

    private static final long serialVersionUID = 5646859336197739469L;
    private EssayBean essay;
    private EssayService service;

    public EssayBean getEssay() {
        return essay;
    }

    public void setEssay(EssayBean essay) {
        this.essay = essay;
    }

    @Autowired
    public EssayEditAction(EssayService service){
        this.service = service;
    }

    @Action(value = "/edit", interceptorRefs = {@InterceptorRef("loginInterceptor")},
            results ={@Result(name = "success", type = "json", params = {"root", "data"}),
            @Result(name = "error", type = "json", params = {"root", "data"})})
    public String edit(){
        if (this.essay != null) {
            if (service.saveEssay(this.essay)) {
                data.setCode(200);
                data.setMsg("保存成功！");
                return SUCCESS;
            }else {
                data.setNormalMsg("保存失败！");
                return ERROR;
            }
        }else {
            data.setNormalMsg("传输对象为空！");
            return ERROR;
        }
    }
}
