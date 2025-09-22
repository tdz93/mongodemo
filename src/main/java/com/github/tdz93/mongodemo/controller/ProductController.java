package com.github.tdz93.mongodemo.controller;

import com.github.tdz93.mongodemo.entity.Product;
import com.github.tdz93.mongodemo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @GetMapping("/name")
    public ResponseEntity<List<Product>> findByNameContaining(
            @RequestParam("name") String name
    ) {
        return ResponseEntity.ok(service.findByNameContaining(name));
    }

    @GetMapping("/price/lte")
    public ResponseEntity<List<Product>> findByPriceLte(
            @RequestParam("price") BigDecimal price
            ) {
        return ResponseEntity.ok(service.findByPriceLte(price));
    }

    @GetMapping("/price/gte")
    public ResponseEntity<List<Product>> findByPriceGte(
            @RequestParam("price") BigDecimal price
            ) {
        return ResponseEntity.ok(service.findByPriceGte(price));
    }

    @GetMapping("/sort/asc")
    public ResponseEntity<List<Product>> sortByFieldAsc(
            @RequestParam("field") String field,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "2") int size
    ) {
        return ResponseEntity.ok(service.sortByFieldAsc(field, page, size));
    }

    @GetMapping("/sort/desc")
    public ResponseEntity<List<Product>> sortByFieldDesc(
            @RequestParam("field") String field,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "2") int size
    ) {
        return ResponseEntity.ok(service.sortByFieldDesc(field, page, size));
    }

}
