package com.j2e.service.essay;

import com.j2e.dto.EssayDto;
import com.j2e.entities.EssayBean;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/14 23:18
 * @description
 */
public interface EssayService {

    boolean saveEssay(EssayBean dto);

    void updateEssay(EssayBean essay);

    List<EssayDto> AllEssay();

    List<EssayDto> searchEssay(String str);

    void deleteEssayById(String eId);

    EssayDto getEssay(String str);
}
