package com.j2e.service.tag;

import com.j2e.entities.TagBean;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/14 22:16
 * @description tag服务接口
 */
public interface TagService {

    List<TagBean> findTags(String keyWord);
}
