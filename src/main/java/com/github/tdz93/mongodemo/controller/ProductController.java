package com.github.tdz93.mongodemo.controller;

import com.github.tdz93.mongodemo.entity.Product;
import com.github.tdz93.mongodemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<String> save(
            @RequestBody Product product
    ) {
        return ResponseEntity.ok(service.save(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<Product> findById(
            @PathVariable("product-id") String id
    ) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("product-id") String id
    ) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
