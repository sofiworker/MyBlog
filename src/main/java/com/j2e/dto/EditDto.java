package com.j2e.dto;

import lombok.Data;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/13 22:45
 * @description 文章传输层
 */
@Data
public class EditDto {
    private String title;
    private String content;
    private String userId;
    private int tagId;
}
