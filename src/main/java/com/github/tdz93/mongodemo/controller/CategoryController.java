package com.github.tdz93.mongodemo.controller;

import com.github.tdz93.mongodemo.entity.Category;
import com.github.tdz93.mongodemo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    public ResponseEntity<String> save(
            @RequestBody Category category
    ) {
        return ResponseEntity.ok(service.save(category));
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{category-id}")
    public ResponseEntity<Category> findById(
            @PathVariable("category-id") String id
    ) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{category-id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable("category-id") String id
    ) {
        service.delete(id);
        return ResponseEntity.accepted().build();
    }

}
