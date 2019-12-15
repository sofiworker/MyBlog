package com.j2e.dao.comment;

import com.j2e.entities.CommentBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/15 14:17
 * @description 评论
 */
public interface CommentDao {
    void saveOneComment(CommentBean comment);
}
