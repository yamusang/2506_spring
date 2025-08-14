package org.iclass.spring_2di.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomerController {
    private CustomerService service;

    @Autowired // setter를 코딩해서 직접 실행하지 않아도 @Autowired로 자동 주입 실행
    public void setService(CustomerService service) { // setService 이외에 makeService등등 다른 이름도 OK!
        // 인자의 타입 중요. 인자 타입의 bean을 가져와서 대입문 실행 => setter로 의존관계 주입
        this.service = service;
        log.info("setService 실행 완료!!");
    }

    public void test() {
        log.info("CustomerController setter - service : ", this.service.getClass().toString());
        service.print();
    }
}
