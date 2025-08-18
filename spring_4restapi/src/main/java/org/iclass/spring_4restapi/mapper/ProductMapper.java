package org.iclass.spring_4restapi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.iclass.spring_4restapi.dto.ProductDto;

@Mapper
public interface ProductMapper {
    List<ProductDto> selectByPk(String pcode);

    List<ProductDto> selectAll();

    int insert(ProductDto pd);

    int update(ProductDto pd);

    int delete(String pcode);
}
