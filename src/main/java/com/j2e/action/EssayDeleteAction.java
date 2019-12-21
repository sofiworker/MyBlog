package com.j2e.action;

import cn.hutool.core.util.StrUtil;
import com.j2e.service.essay.EssayService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/19 19:27
 * @description 删除用户文章
 */
@Controller
public class EssayDeleteAction extends BaseAction<String>{
    private static final long serialVersionUID = -3184605533213337591L;
    private EssayService service;
    private String essayId;

    public String getEssayId() {
        return essayId;
    }

    public void setEssayId(String essayId) {
        this.essayId = essayId;
    }

    @Autowired
    public EssayDeleteAction(EssayService service){
        this.service = service;
    }

//    interceptorRefs = {@InterceptorRef("loginInterceptor")},
    @Action(value = "/delete",
            results ={@Result(name = "success", type = "json", params = {"root", "data"}),
                    @Result(name = "error", type = "json", params = {"root", "data"})})
    public String delete(){
        if (!StrUtil.isEmpty(essayId)) {
            service.deleteEssayById(essayId);
            return SUCCESS;
        }else {
            data.setNormalMsg("传输对象为空！");
            return ERROR;
        }
    }
}
