package com.j2e.action;

import cn.hutool.core.util.StrUtil;
import com.j2e.dto.CommentItemDto;
import com.j2e.service.comment.CommentService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/17 20:43
 * @description 获取文章评论action
 */
@Controller
public class CommentListAction extends BaseAction<List<CommentItemDto>>{

    private static final long serialVersionUID = 2112682432060485038L;
    private String essayId;
    private CommentService service;

    public String getEssayId() {
        return essayId;
    }

    public void setEssayId(String essayId) {
        this.essayId = essayId;
    }

    @Autowired
    public CommentListAction(CommentService service){
        this.service = service;
    }

    @Action(value = "/commentList", interceptorRefs = {@InterceptorRef("loginInterceptor")},
            results ={@Result(name = "success", type = "json", params = {"root", "data"}),
                    @Result(name = "error", type = "json", params = {"root", "data"})})
    public String commentEssay(){
        if (!StrUtil.isEmpty(essayId)) {
            data.setData(service.getEssayCommentList(essayId));
            return SUCCESS;
        }else {
            data.setNormalMsg("获取失败！");
            return ERROR;
        }
    }
}
