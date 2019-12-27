package com.j2e.action;

import com.j2e.entities.CommentBean;
import com.j2e.service.replay.ReplayService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/27 9:46
 * @description 回复通知action
 */
@Controller
public class ReplayAction extends BaseAction<List<CommentBean>>{

    private static final long serialVersionUID = 5087072709353075941L;
    private ReplayService service;

    @Autowired
    public ReplayAction(ReplayService service){
        this.service = service;
    }

    @Action(value = "/replay", interceptorRefs = {@InterceptorRef("loginInterceptor")},
            results ={@Result(name = "success", type = "json", params = {"root", "data"}),
                    @Result(name = "error", type = "json", params = {"root", "data"})})
    public String replay(){
        List<CommentBean> replay = service.getReplay();
        if (!replay.isEmpty()){
            data.setData(replay);
            return SUCCESS;
        }else {
            data.setNormalMsg("获取失败！");
            return ERROR;
        }
    }
}
