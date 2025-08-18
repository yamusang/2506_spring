package org.iclass.spring_4restapi.controller;

import java.util.List;
import java.util.Map;

import org.iclass.spring_4restapi.dto.ProductDto;
import org.iclass.spring_4restapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@Slf4j
@AllArgsConstructor
@RestController
public class ProductRestController {
    private ProductService service;

    @GetMapping("/api/products")
    public ResponseEntity<List<ProductDto>> getProducts() {
        return ResponseEntity.ok().body(service.allProducts());
    }

    @GetMapping("/api/products/{pcode}")
    public ResponseEntity<List<ProductDto>> getProduct(@PathVariable String pcode) {
        return ResponseEntity.ok().body(service.getProduct(pcode));
    }

    @PostMapping("/api/products")
    public ResponseEntity<?> save(@RequestBody ProductDto dto) {
        try {
            int result = service.join(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("success", result));
        } catch (Exception e) {
            log.info("save 예외 : {}", e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }

    }

    @PutMapping("/api/products/{pcode}")
    public ResponseEntity<?> update(@PathVariable String pcode, @RequestBody ProductDto dto) {
        try {
            return ResponseEntity.ok().body(Map.of("success", service.update(dto)));
        } catch (Exception e) {
            log.info("update 예외 : {}", e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/api/products/{pcode}")
    public ResponseEntity<?> delete(@PathVariable String pcode) {
        try {
            int result = service.delete(pcode);
            if (result == 0) {
                throw new IllegalArgumentException("id: " + pcode + "존재하지 않습니다.");
            }
            return ResponseEntity.ok().body(Map.of("success", result));
        } catch (Exception e) {
            log.info("update 예외 : {}", e.getMessage());
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
