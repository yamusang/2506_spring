package org.iclass.spring_4restapi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.spring_4restapi.dto.BuyDto;
import org.iclass.spring_4restapi.dto.CustomerBuyDto;

@Mapper // dao 역할을 하는 인터페이스
public interface BuyMapper {
    List<BuyDto> selectId(String customerId);

    List<BuyDto> selectPcode(String pcode);

    List<BuyDto> selectYQ(String date);

    Integer selectSum(String pcode);

    // join

    List<CustomerBuyDto> selectMoneyByCustomer(String customer_id);

    // count 집계 함수

    Map<String, Integer> selectCountByYear(String year);

    List<Map<String, Object>> selectAllCountByYear();
}
