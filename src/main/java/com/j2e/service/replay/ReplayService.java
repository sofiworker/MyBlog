package com.j2e.service.replay;

import com.j2e.entities.CommentBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/27 9:51
 * @description 服务接口
 */
public interface ReplayService {

    List<CommentBean> getReplay();
}
