package org.iclass.spring_2di.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomerService {
    private CustomerDao dao;

    @Autowired // =>자동 주입 없을 때 NullPointerException 확인하기 : setter자동 실행하지 않고, dao bean 가져오기 X
    public void setDao(CustomerDao dao) {
        this.dao = dao;
    }

    public void test() {
        log.info("CustomerService setter - dao : {}", this.dao.getClass().toString());
        dao.setGroups(); // dao가 null이 아니면 정상실행
    }

    public void print() {
        log.info("service message: HI~");
    }
}
