package org.iclass.spring_5webmvc.controller;

import java.util.List;

import org.iclass.spring_3mybatis.dto.ProductDto;
import org.iclass.spring_3mybatis.mapper.ProductMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
public class TestController_5ModelAttribute {
    // 자동 주입 필요 -> 생성자
    private ProductMapper productMapper;

    @GetMapping("/product/search")
    public String search(@ModelAttribute("keyword") String keyword,
            @ModelAttribute(name = "page") String page) {
        log.info("파라미터 : {}, {}", keyword, page);
        log.info("product/search.html로 2개의 값을 keyword,page 애트리뷰트 이름으로 전달합니다.");
        return "product/search";
    }

    // @ModelAttribute는 단일 파라미터에서는 잘 사용하지 ❌, 주로 여러개 필드를 묶은 dto에서 사용
    @GetMapping("/product/search2")
    public String search2(@ModelAttribute ProductDto dto) {
        log.info("파라미터 dto : {}", dto);
        log.info("product/search.html로 dto에 저장된 파라미터 값이 search.html에 보이는지 확인하기!!");
        return "product/search";
    }

    @GetMapping("/product/list")
    public String prod_list(Model model) {
        List<ProductDto> pList = productMapper.selectAll();
        model.addAttribute("pList", pList);
        return "product/list";
    }

    @PostMapping("/product/list")
    public String prod_search(@ModelAttribute(name = "keyword") String keyword, Model model) {
        log.info("ModelAttribute : {}", keyword);
        model.addAttribute("pList", productMapper.selectByPk(keyword));
        return "product/list";
    }

    // @ModelAttribute : 파라미터 + 애트리뷰트, Model : 애트리뷰트 저장
}
