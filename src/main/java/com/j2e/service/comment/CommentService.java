package com.j2e.service.comment;

import com.j2e.dto.CommentDto;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/15 14:18
 * @description 评论service
 */
public interface CommentService {

    void saveOneComment(CommentDto dto);
}
