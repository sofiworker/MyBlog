package com.j2e.action;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.j2e.Constants;
import com.j2e.dto.ImgDto;
import com.j2e.entities.BaseData;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/25 19:30
 * @description 文章图片上传
 */
public class EssayImgAction extends ActionSupport {

    private static final long serialVersionUID = -6870660187128952918L;
    private BaseData<ImgDto> data = new BaseData<>();
    private File file;
    private String fileFileName;
    private String fileContentType;
    private String newName;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String essayImg() throws Exception{
        newName = createNewName();
        InputStream imgStream = new FileInputStream(file);
        Image src = ImageIO.read(imgStream);
        BufferedImage img = new BufferedImage(600, 300, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = img.createGraphics();
        g.drawImage(src, 0, 0, 600, 300, null);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(img, getSuffixName(), out);
        byte[] b = out.toByteArray();
        out.close();
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload/essayImg/");
        if (!new File(uploadPath).exists()){
            new File(uploadPath).mkdirs();
        }
        File toFile = new File(uploadPath + File.separator + newName);
        FileImageOutputStream outputStream = new FileImageOutputStream(toFile);
        outputStream.write(b, 0, b.length);
        outputStream.close();
        String url = getUrl();
        ImgDto data = new ImgDto();
        data.setSrc(url);
        data.setTitle(newName);
        this.data.setCode(0);
        this.data.setData(data);
        ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
        ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
        ServletActionContext.getResponse().getWriter().print(JSON.toJSONString(this.data));
        return NONE;
    }

    private String createNewName(){
        return IdUtil.simpleUUID() + "."+ getSuffixName();
    }

    private String getSuffixName(){
        return fileFileName.substring(fileFileName.lastIndexOf(".") + 1);
    }

    private String getUrl() throws UnknownHostException {
        String host = InetAddress.getLocalHost().getHostAddress();
        return "http://"+host + ":" + Constants.PORT + "/upload/essayImg/" + newName;
    }
}
