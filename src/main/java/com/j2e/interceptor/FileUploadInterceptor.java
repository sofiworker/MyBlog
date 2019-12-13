package com.j2e.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/11 17:20
 * @description 文件上传拦截器
 */
public class FileUploadInterceptor extends AbstractInterceptor {
    private static final long serialVersionUID = 9235942185998337L;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String fileUploadAction = "FileUploadAction";
        if (fileUploadAction.equals(invocation.getAction().getClass().getSimpleName())) {
        }
        return invocation.invoke();
    }
}
