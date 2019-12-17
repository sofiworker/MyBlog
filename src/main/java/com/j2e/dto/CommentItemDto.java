package com.j2e.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/17 21:01
 * @description 评论列表dto
 */
@Data
public class CommentItemDto {
    private String uid;
    private String username;
    private String photo;
    private int level;
    private String content;
    private String eid;
    private Timestamp createTime;
}
