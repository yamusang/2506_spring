package org.iclass.spring_4restapi.service;

import java.util.List;

import org.iclass.spring_4restapi.dto.CustomerDto;
import org.iclass.spring_4restapi.mapper.CustomerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@Component
@Slf4j
@AllArgsConstructor
@Transactional
@Service
public class CustomerService {
    private CustomerMapper mapper;

    // 비즈니스 로직 : 업무관련 처리 - 회원 등록, 회원 탈퇴, 회원정보 수정회원 조회, 이메일 중복 검사...
    // 복잡한 업무 로직은 2개 이상의 DML 명령어를 실행할 수 있습니다. -> 트랜잭션 처리. 오류가 발생하면 모든 단위 SQL 롤백.
    public int join(CustomerDto dto) {
        return mapper.insert(dto);
    }

    public List<CustomerDto> allCustomers() {
        return mapper.selectAll();
    }

    public CustomerDto getCustomer(String customerid) {
        return mapper.selectByPk(customerid);
    }

    public int update(CustomerDto dto) {
        return mapper.update(dto);
    }

    public int delete(String customerId) {
        return mapper.delete(customerId);
    }
}
