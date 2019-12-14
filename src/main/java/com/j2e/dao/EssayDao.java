package com.j2e.dao;

import com.j2e.entities.EssayBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/9 9:27
 * @description 编写文章的dao层
 */
public interface EssayDao {

    boolean saveEssay(EssayBean essay);
}
