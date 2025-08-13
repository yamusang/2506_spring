package org.iclass.spring_1demo.spring;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NewDemoController {
    @Autowired
    private NewDemoService service;

    public NewDemoController() {
        log.info("NewDemoController 생성자 -");
        // log.info("NewDemoController 생성자 -", this.service.getClass().toString());
        // 예외 : this.service is null => 생성자 실행 후 필드 주입
    }
}
