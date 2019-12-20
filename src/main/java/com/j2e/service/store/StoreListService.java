package com.j2e.service.store;

import com.j2e.dto.StoreDto;
import java.util.List;

/**
 * @author mynameexit
 * @version 1.0.0
 * @date 2019/12/ 20:40
 * @description 收藏接口
 */

public interface StoreListService {

    List<StoreDto> findstore();
}
