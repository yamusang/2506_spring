package org.iclass.spring_5webmvc.controller;

import java.util.List;

import org.iclass.spring_3mybatis.dto.CustomerDto;
import org.iclass.spring_3mybatis.mapper.CustomerMapper;
import org.iclass.spring_5webmvc.dto.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
public class TestController_4Attribute {

    // 생성자 주입 : 생성자에서 같은 타입의 bean을 가져와 초기화
    private CustomerMapper customerMapper;

    @GetMapping("/customer/list")
    public String list(Model model) {
        // 메소드 인자인 Model 타입 bean 자동 주입됩니다.
        model.addAttribute("pageNo", 100);
        model.addAttribute("dto", TestDto.builder().name("길동GD").address("서울").build());
        model.addAttribute("list", List.of("twice", "아이브", "newjeans", "소녀시대"));

        return "customer/list"; // templates 폴더 아래 customer 폴더에 list.html 저장
    }

    @GetMapping("/customer/cuslist")
    public String getMethodName(Model model) {
        List<CustomerDto> cusList = customerMapper.selectAll();

        // customer/list.html에서 필요한
        // 애트리뷰트 page,dto,list는 저장 안하고 테스트
        model.addAttribute("cusList", cusList);
        return "customer/list";
    }

}
