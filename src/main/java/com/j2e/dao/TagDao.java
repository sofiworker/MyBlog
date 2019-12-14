package com.j2e.dao;

import com.j2e.entities.TagBean;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/14 22:14
 * @description 标签dao层
 */
public interface TagDao {
    List<TagBean> findTagByKeyWord(String keyWord);
}
