package org.iclass.spring_4restapi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.spring_4restapi.dto.CustomerDto;

@Mapper // 이 어노테이션은 bean은 만들지만 sql 매퍼 구현체는 아닙니다.
// dao 역할을 하는 인터페이스
public interface CustomerMapper {
    CustomerDto selectByPk(String customerId);

    List<CustomerDto> selectAll();

    int insert(CustomerDto cd);

    int update(CustomerDto cd);

    int delete(String customer_id);

}
