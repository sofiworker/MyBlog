package com.j2e.action;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.j2e.Constants;
import com.j2e.entities.BaseData;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/11 16:23
 * @description 文件上传action
 */
public class FileUploadAction extends ActionSupport {

    private static final long serialVersionUID = 8934089440719746421L;

    private File uploadFile;
    private String uploadFileContentType;
    private String uploadFileFileName;
    private String newName;

    public String getUploadFileContentType() {
        return uploadFileContentType;
    }

    public void setUploadFileContentType(String uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }

    public String getUploadFileFileName() {
        return uploadFileFileName;
    }

    public void setUploadFileFileName(String uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }

    public File getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String fileUpload() throws Exception{
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
        newName = createNewName();
        File toFile = new File(uploadPath + File.separator + newName);
        FileUtils.copyFile(uploadFile, toFile);
        BaseData<String> data = new BaseData<>();
        String url = getUrl();
        data.setData(url);
        ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
        ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
        ServletActionContext.getResponse().getWriter().print(JSON.toJSONString(data));
        return  NONE;
    }

    private String createNewName(){
        return IdUtil.simpleUUID() + "."+uploadFileFileName.substring(uploadFileFileName.lastIndexOf(".") + 1);
    }

    private String getUrl() throws UnknownHostException{
        String host = InetAddress.getLocalHost().getHostAddress();
        return host + ":" + Constants.PORT + "/upload/" + newName;
    }
}
