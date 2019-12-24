package com.j2e.service.tag;

import com.j2e.dao.tag.TagDao;
import com.j2e.entities.TagBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/14 22:17
 * @description 实现层
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class TagServiceImpl implements TagService {

    private TagDao tagDao;

    @Autowired
    public TagServiceImpl(TagDao dao){
        this.tagDao = dao;
    }

    @Override
    public List<TagBean> findTags() {
        return tagDao.findTagByKeyWord();
    }
}
