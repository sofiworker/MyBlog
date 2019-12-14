package com.j2e.action;

import com.j2e.entities.TagBean;
import com.j2e.service.TagService;
import lombok.extern.log4j.Log4j2;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/14 22:12
 * @description 文章查询tag的action
 */
@Component
@Log4j2
public class TagAction extends BaseAction<List<TagBean>> {

    private static final long serialVersionUID = 1358050148613013698L;

    private String keyWord;
    private TagService service;

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Autowired
    public TagAction(TagService service){
        this.service = service;
    }

    @Action(value = "/searchTag", interceptorRefs = {@InterceptorRef("loginInterceptor")},
            results ={@Result(name = "success", type = "json", params = {"root", "data"}),
                    @Result(name = "error", type = "json", params = {"root", "data"})})
    public String searchTag(){
        if (keyWord == null || keyWord.length() == 0){
            data.setNormalMsg("输入字段格式问题！");
            return ERROR;
        }else {
            List<TagBean> tags = service.findTags(keyWord);
            if (tags != null && !tags.isEmpty()) {
                data.setData(tags);
                return SUCCESS;
            }else {
                data.setNormalMsg("查询失败！");
                return ERROR;
            }
        }
    }
}
