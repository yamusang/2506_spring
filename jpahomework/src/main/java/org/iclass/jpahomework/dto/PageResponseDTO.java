package org.iclass.jpahomework.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageResponseDTO {
  // private int currentPage; //현재 페이지 추가할 수 있음.
  private int totalCount; // 전체 글 개수
  private int totalPages; // 전체 페이지 개수

  private int startPage;
  private int endPage;

  private List<CommunityDto> list; // 요청 페이지의 글목록

}
