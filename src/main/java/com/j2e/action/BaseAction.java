package com.j2e.action;

import com.j2e.entities.BaseData;
import com.opensymphony.xwork2.ActionSupport;
import lombok.extern.log4j.Log4j2;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/10 15:52
 * @description action的基类
 */
@ParentPackage("com.j2e")
@InterceptorRef(value="json")
public class BaseAction<T> extends ActionSupport {

    private static final long serialVersionUID = -7447806210536405023L;
    protected BaseData<T> data = new BaseData<>();

    public BaseData<T> getData() {
        return data;
    }

    public void setData(BaseData<T> data) {
        this.data = data;
    }
}
