package com.github.tdz93.mongodemo.service;

import com.github.tdz93.mongodemo.entity.Category;
import com.github.tdz93.mongodemo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public String save(Category category) {
        return repository.save(category).getId();
    }

    public Category findById(String id) {
        return repository.findById(id)
                .orElse(null);
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
