package com.j2e.action;

import com.j2e.dto.CommentDto;
import com.j2e.service.comment.CommentService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/15 13:47
 * @description 用户评论action
 */
@Controller
public class CommentAction extends BaseAction<String> {

    private static final long serialVersionUID = -3297492641061615430L;

    private CommentDto comment;
    private CommentService service;

    public CommentDto getComment() {
        return comment;
    }

    public void setComment(CommentDto comment) {
        this.comment = comment;
    }

    @Autowired
    public CommentAction(CommentService service){
        this.service = service;
    }

    @Action(value = "/comment", interceptorRefs = {@InterceptorRef("loginInterceptor")},
            results ={@Result(name = "success", type = "json", params = {"root", "data"}),
                    @Result(name = "error", type = "json", params = {"root", "data"})})
    public String commentEssay(){
        if (comment != null) {
            service.saveOneComment(comment);
            return SUCCESS;
        }else {
            data.setData(null);
            data.setNormalMsg("保存失败！");
            return ERROR;
        }
    }
}
