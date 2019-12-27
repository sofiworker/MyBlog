package com.j2e.dto;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class EssayDto {
    private String eId;
    private String eTitle;
    private String eContent;
    private int eLike;
    private int eComment;
    private String userName;
    private String tagName;
    private Timestamp createTime;
    private String userId;
}