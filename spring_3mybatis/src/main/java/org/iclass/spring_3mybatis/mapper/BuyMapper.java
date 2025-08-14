package org.iclass.spring_3mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.spring_3mybatis.dto.BuyDto;
import org.iclass.spring_3mybatis.dto.CustomerBuyDto;

@Mapper
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
