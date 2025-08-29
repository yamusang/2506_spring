package org.iclass.jpahomework.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface CommunityListDto {
  Integer getIdx();

  String getWriter();

  String getTitle();

  String getContent();

  Integer getReadcount();

  LocalDate getCreatedat();

  String getIp();

  Integer getCommentcount();
}
