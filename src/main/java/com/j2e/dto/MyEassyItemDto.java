package com.j2e.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author mynameexit
 * @version 1.0.0
 * @date 2019/12/ 20:40
 * @description 我的文章
 */

@Data
public class MyEassyItemDto {
    private String eid;
    private String etitle;
    private String econtent;
    private int elike;
    private int ecomment;
    private String uid;
    private String uname;
    private int tagid;
    private String tagname;
    private Timestamp createTime;
}
