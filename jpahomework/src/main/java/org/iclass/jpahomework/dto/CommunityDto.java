package org.iclass.jpahomework.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.iclass.jpahomework.entity.CommunityEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CommunityDto {

  // private Integer r;
  private Integer idx;
  private String writer;
  private String title;
  private String content;
  private Integer readcount;
  private LocalDate createdat;
  private String ip;
  private Integer commentcount;

  public static CommunityDto of(CommunityEntity entity) {
    return CommunityDto.builder()
        .idx(entity.getIdx())
        .writer(entity.getWriter())
        .title(entity.getTitle())
        .content(entity.getContent())
        .readcount(entity.getReadcount())
        .createdat(entity.getCreatedat())
        .ip(entity.getIp())
        .commentcount(entity.getCommentcount())
        .build();
  }
}
