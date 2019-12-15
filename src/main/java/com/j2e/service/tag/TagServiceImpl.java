package com.j2e.service.tag;

import com.j2e.dao.tag.TagDao;
import com.j2e.entities.TagBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/14 22:17
 * @description 实现层
 */
@Service
public class TagServiceImpl implements TagService {

    private TagDao tagDao;

    @Autowired
    public TagServiceImpl(TagDao dao){
        this.tagDao = dao;
    }

    @Override
    public List<TagBean> findTags(String keyWord) {
        return tagDao.findTagByKeyWord(keyWord);
    }
}
