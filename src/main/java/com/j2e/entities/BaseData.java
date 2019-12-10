package com.j2e.entities;

import lombok.Data;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/10 13:31
 * @description 返回json数据的基类
 */
@Data
public class BaseData<T> {

    private int code = 200;
    private String msg = "成功";
    private T data;

    public void setNormalMsg(String msg){
        this.code = 400;
        this.msg = msg;
    }
}
