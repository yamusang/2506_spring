package org.iclass.spring_1demo.old;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DemoDao {
    private String message;

    public DemoDao() {
        this.message = "Hello, Spring!!";
        log.info("DemoDao 생성자 - message : {}", this.message);
    }
}
