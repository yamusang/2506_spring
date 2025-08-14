package org.iclass.spring_2di.component;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//@AllArgsConstructor
@Component
@Slf4j
public class ProductService {
    private ProductDao dao;
//생성자가 실행되면서 ProductDao타입의 bean을 가져와요. 그리고 this.dao에 대입(주입)합니다.
    public ProductService(ProductDao dao) {
        this.dao = dao;
        log.info("ProductDao message : {}", dao.getMessage());
    }

}
