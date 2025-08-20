package org.iclass.spring_5webmvc.controller;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.iclass.spring_5webmvc.dto.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestController_2Parameter {

    @GetMapping("/list")
    public String list(String name, @RequestParam(defaultValue = "0") int age) {
        log.info("name : {}, age : {}", name, age);
        return "list";
    }

    // 파라미터 4개 받기 : name, age, address, gender(String)

    @GetMapping("/listA")
    public String listA(String name, int age, String address, String gender) {
        log.info("파라미터 : {} {} {} {}", name, age, address, gender);
        return "list";
    }

    @GetMapping("/listB")
    public String listB(TestDto dto) {
        log.info("파라미터 저장 dto : {}", dto);
        return "list";
    }

    @PostMapping("/list")
    public String save(TestDto dto) {
        log.info("파라미터 저장 dto : {}", dto);
        // TODO: process POST request

        return "redirect:/list?name=" + URLEncoder.encode(dto.getName(), StandardCharsets.UTF_8) + "&age="
                + dto.getAge();
    }

}
