package com.j2e.dto;

import lombok.Data;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/15 13:50
 * @description 评论dto
 */
@Data
public class CommentDto {
    private int level;
    private String content;
    private String eid;
}
