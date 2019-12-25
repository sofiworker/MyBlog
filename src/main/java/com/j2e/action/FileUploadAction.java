package com.j2e.action;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.j2e.Constants;
import com.j2e.dto.ImgDto;
import com.j2e.entities.BaseData;
import com.opensymphony.xwork2.ActionSupport;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/11 16:23
 * @description 文件上传action
 */
@Log4j2
public class FileUploadAction extends ActionSupport {

    private static final long serialVersionUID = 8934089440719746421L;

    private BaseData<ImgDto> data = new BaseData<>();
    private File file;
    private String fileContentType;
    private String fileFileName;
    private String newName;
    private int width;
    private int height;

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String fileUpload() throws Exception{
        newName = createNewName();
        ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
        ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
        if (width > 0 && height > 0){
            saveModifyImg();
        }else {
            saveOriginalImg();
        }
        return  NONE;
    }

    private void saveModifyImg() throws Exception {
        InputStream imgStream = new FileInputStream(file);
        Image src = ImageIO.read(imgStream);
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();
        g.drawImage(src, 0, 0, width, height, null);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(img, getSuffixName(), out);
        byte[] b = out.toByteArray();
        out.close();
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload/modify/");
        if (!new File(uploadPath).exists()){
            if (new File(uploadPath).mkdir()) {
                File toFile = new File(uploadPath + File.separator + newName);
                FileImageOutputStream outputStream = new FileImageOutputStream(toFile);
                outputStream.write(b, 0, b.length);
                outputStream.close();
                String url = getUrl();
                ImgDto data = new ImgDto();
                data.setSrc(url);
                data.setTitle(newName);
                this.data.setData(data);
                ServletActionContext.getResponse().getWriter().print(JSON.toJSONString(this.data));
            }
        }
    }

    private void saveOriginalImg() throws Exception{
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload/original/");
        File toFile = new File(uploadPath + File.separator + newName);
        FileUtils.copyFile(file, toFile);
        String url = getUrl();
        ImgDto data = new ImgDto();
        data.setSrc(url);
        data.setTitle(newName);
        this.data.setData(data);
        ServletActionContext.getResponse().getWriter().print(JSON.toJSONString(this.data));
    }

    private String createNewName(){
        return IdUtil.simpleUUID() + "."+ getSuffixName();
    }

    private String getSuffixName(){
        return fileFileName.substring(fileFileName.lastIndexOf(".") + 1);
    }

    private String getUrl() throws UnknownHostException{
        String host = InetAddress.getLocalHost().getHostAddress();
        if (width > 0 && height > 0){
            return "http://"+host + ":" + Constants.PORT + "/upload/modify/" + newName;
        }else {
            return "http://"+host + ":" + Constants.PORT + "/upload/original/" + newName;
        }
    }
}
