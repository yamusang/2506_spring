package org.iclass.spring_4restapi.service;

import java.util.List;

import org.iclass.spring_4restapi.dto.ProductDto;
import org.iclass.spring_4restapi.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Transactional
@Service
public class ProductService {
    private ProductMapper mapper;

    public int join(ProductDto dto) {
        return mapper.insert(dto);
    }

    public List<ProductDto> allProducts() {
        return mapper.selectAll();
    }

    public List<ProductDto> getProduct(String pcode) {
        return mapper.selectByPk(pcode);
    }

    public int update(ProductDto dto) {
        return mapper.update(dto);
    }

    public int delete(String pcode) {
        return mapper.delete(pcode);
    }
}
