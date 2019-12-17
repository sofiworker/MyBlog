package com.j2e.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author sofiworker
 * @version 1.0.0
 * @date 2019/12/13 19:29
 * @description user实体的传输层
 */
@Data
public class UserDto {
    private String uid;
    private String username;
    private String photo;
    private String gender;
    private String sign;
    private int type;
    private Timestamp createTime;
}
