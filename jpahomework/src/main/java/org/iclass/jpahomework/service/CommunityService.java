package org.iclass.jpahomework.service;

import java.util.List;
import java.util.stream.Collectors;

import org.iclass.jpahomework.dto.CommunityDto;
import org.iclass.jpahomework.dto.CommunityListDto;
import org.iclass.jpahomework.dto.PageResponseDTO;
import org.iclass.jpahomework.entity.CommunityEntity;
import org.iclass.jpahomework.repository.CommunityRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommunityService {
  private final CommunityRepository communityRepository;

  public List<CommunityDto> communityList() {
    List<CommunityEntity> entitylist = communityRepository.findAll();
    return entitylist.stream().map(CommunityDto::of).collect(Collectors.toList());
  }

  public PageResponseDTO getPageList(int currentPage) {
    int pageSize = 5; // 한 페이지에 글 몇개인지 설정 변수. 다른 값으로 변경 가능
    int startNo = (currentPage - 1) * pageSize + 1;
    int endNo = startNo + (pageSize - 1);

    // 1. Repository로부터 인터페이스 타입의 리스트를 받습니다.
    List<CommunityListDto> interfaceList = communityRepository.selectPageList(startNo, endNo);

    // 2. Stream api를 사용하여 List<CommunityListDto>를 List<CommunityDto>로 변환합니다.
    List<CommunityDto> dtoList = interfaceList.stream()
        .map(dto -> CommunityDto.builder()
            .idx(dto.getIdx())
            .writer(dto.getWriter())
            .title(dto.getTitle())
            .createdat(dto.getCreatedat())
            .readcount(dto.getReadcount())
            .commentcount(dto.getCommentcount())
            .ip(dto.getIp())
            // content는 목록에 필요 없으면 생략 가능
            .build())
        .collect(Collectors.toList());

    // --- 페이지 계산 로직은 그대로 ---
    int totalCount = communityRepository.getAllCount();
    double temp = (double) totalCount / pageSize;
    int totalPages = (int) Math.ceil(temp);
    int s = 5;
    int startPage = (currentPage - 1) / s * s + 1;
    int endPage = startPage + (s - 1);
    endPage = Math.min(totalPages, endPage);

    // 3. 변환된 dtoList를 빌더에 전달합니다.
    PageResponseDTO responseDTO = PageResponseDTO.builder()
        .totalCount(totalCount)
        .totalPages(totalPages)
        .startPage(startPage)
        .endPage(endPage)
        .list(dtoList) // 수정된 부분
        .build();

    return responseDTO;
  }
}
