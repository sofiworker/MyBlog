package com.j2e.dto;


import lombok.Data;

/**
 * @author mynameexit
 * @version 1.0.0
 * @date 2019/12/ 20:40
 * @description 收藏传输层
 */

@Data
public class StoreDto {
    private String UserName;
    private String Uid;
    private String eid;
    private String etitle;
    private String econtent;
}
