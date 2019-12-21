package com.j2e.action;

import com.j2e.entities.EssayBean;
import com.j2e.service.essay.EssayService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/15 13:25
 * @description 用户文章修改action
 */
public class EssayModifyAction extends BaseAction<String>{
    private static final long serialVersionUID = 8598209508708546456L;

    private EssayBean essay;
    private EssayService service;

    public EssayBean getEssay() {
        return essay;
    }

    public void setEssay(EssayBean essay) {
        this.essay = essay;
    }

    public EssayModifyAction(EssayService service){
        this.service = service;
    }

    @Action(value = "/modify", interceptorRefs = {@InterceptorRef("loginInterceptor")},
            results ={@Result(name = "success", type = "json", params = {"root", "data"}),
                    @Result(name = "error", type = "json", params = {"root", "data"})})
    public String updateEssay(){
        if (essay != null){
            service.updateEssay(essay);
            data.setMsg("更新成功！");
            return SUCCESS;
        }else {
            data.setData(null);
            data.setNormalMsg("传输对象为空！");
            return ERROR;
        }
    }
}
