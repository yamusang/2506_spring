package org.iclass.jpahomework.controller;

import java.time.LocalDate;

import org.iclass.jpahomework.dto.PageResponseDTO;
import org.iclass.jpahomework.service.CommunityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class APICommunityController {
  private final CommunityService communityService;

  @GetMapping("/community/list")
  public String list(@RequestParam(defaultValue = "1") int page, Model model) {
    PageResponseDTO pageList = communityService.getPageList(page);
    model.addAttribute("pageList", pageList);
    model.addAttribute("page", page); // 검색기능 구현하면 dto 로 작성
    log.info("오늘 날짜 : {}", LocalDate.now());
    model.addAttribute("today", LocalDate.now());
    return "community/list";
  }

}
