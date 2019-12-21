package com.j2e.service.essay;

import cn.hutool.core.util.IdUtil;
import com.j2e.Constants;
import com.j2e.dao.essay.EssayDao;
import com.j2e.dto.UserDto;
import com.j2e.entities.EssayBean;
import com.opensymphony.xwork2.ActionContext;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/14 23:18
 * @description
 */
@Service
@Log4j2
@Transactional(rollbackFor = {Exception.class})
public class EssayServiceImpl implements EssayService {

    private EssayDao dao;

    @Autowired
    public EssayServiceImpl(EssayDao dao){
        this.dao = dao;
    }

    @Override
    public boolean saveEssay(EssayBean bean) {
        bean.seteId(IdUtil.simpleUUID());
        bean.seteLike(0);
        bean.seteComment(0);
        bean.setUserId(getUid());
        return dao.saveEssay(bean);
    }

    private String getUid(){
        UserDto user = (UserDto) ActionContext.getContext().getSession().get(Constants.LOGIN_USER);
        return user.getUid();
    }

    @Override
    public void updateEssay(EssayBean essay) {
        dao.updateEssay(essay);
    }

    @Override
    public List<EssayBean> AllEssay() {
        return dao.AllEssay();
    }

    @Override
    public List<EssayBean> searchEssay(String str) {
        return dao.searchEssay(str);
    }

    @Override
    public void deleteEssayById(String eId) {
        dao.deleteEssayById(eId);
    }
}
