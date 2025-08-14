package org.iclass.spring_3mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.spring_3mybatis.dto.ProductDto;

@Mapper
public interface ProductMapper {
    List<ProductDto> selectByPk(String customerId);

    List<ProductDto> selectAll();

    int insert(ProductDto pd);

    int update(ProductDto pd);

    int delete(String pcode);
}
