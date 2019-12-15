package com.j2e.service.essay;

import com.j2e.dto.EditDto;
import com.j2e.entities.EssayBean;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/14 23:18
 * @description
 */
public interface EssayService {

    boolean saveEssay(EditDto dto);

    void updateEssay(EssayBean essay);
}
