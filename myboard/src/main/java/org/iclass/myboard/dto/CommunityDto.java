package org.iclass.myboard.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommunityDto {

    private Integer idx;
    private String writer;
    private String title;
    private String content;
    private Integer readCount;
    private Date createDat;
    private String ip;
    private Integer commentCount;

}
