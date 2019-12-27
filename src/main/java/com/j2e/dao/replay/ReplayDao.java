package com.j2e.dao.replay;

import com.j2e.entities.CommentBean;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/27 9:55
 * @description 接口
 */
public interface ReplayDao {

    List<CommentBean> getCommentList(String uid);
}
