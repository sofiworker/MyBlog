package com.j2e.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/9 18:11
 * @description 编写文章的action
 */
public class EssayAction extends BaseAction {

    private static final long serialVersionUID = 5646859336197739469L;

//    private String

    @Action(value = "edit", interceptorRefs = {@InterceptorRef("loginInterceptor")},
            results ={@Result(name = "edit", type = "json", params = {"root", "data"})})
    public String edit(){
        return "edit";
    }
}
