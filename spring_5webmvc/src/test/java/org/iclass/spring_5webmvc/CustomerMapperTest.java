package org.iclass.spring_5webmvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.iclass.spring_3mybatis.dto.CustomerDto;
import org.iclass.spring_3mybatis.mapper.CustomerMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional // 스프링부트에서 트랜잭션 관리를 하는 어노테이션. Test 할때에는 테스트 끝나면 rollback
@SpringBootTest
// Bean을 만들 패키지 설정
@ComponentScan(basePackages = { "org.iclass" })
// Sql 매퍼 인터페이스 찾을 패키지 설정
@MapperScan(basePackages = { "org.iclass" })
public class CustomerMapperTest {
    // 회원가입 : insert, 회원정보 수정 update, 회원탈퇴 delete
    // 테스트할 bean 가져오기(필드 자동주입)
    @Autowired
    private CustomerMapper customerMapper;

    @Test
    void mapper() {
        assertNotNull(customerMapper);
    }

    @Test
    void select() {
        log.info("{}", customerMapper.selectAll());
        assertNotEquals(1, customerMapper.selectAll().size());
    }

    @Test
    void join() {
        int result = customerMapper.insert(new CustomerDto("Jangu", "김장구", "jj@korea.kr", 25, null));
        assertEquals(1, result);
    }

    @Test
    void update() {
        int result = customerMapper
                .update(CustomerDto.builder().customerId("JJangu").age(24).email("jj@naver.com").build());
        log.info("{}", customerMapper.selectByPk("JJangu"));
        assertEquals(1, result);
    }

    @Test
    void remove() {
        int result = customerMapper.delete("JJangu");
        assertEquals(1, result);
        assertNull(customerMapper.selectByPk("JJangu"));
    }

}

/*
 * 테스트 클래스에 아래 어노테이션이 없으면 자동커밋은 true.
 * 만약에 테스트 데이터를 테이블에 반영시키고 싶지 않다면 트랜젝션 관리 어노테이션을 사용
 * 
 * 
 * @Transactional => 테스트 메소드 실행이 끝나면 rollback
 */