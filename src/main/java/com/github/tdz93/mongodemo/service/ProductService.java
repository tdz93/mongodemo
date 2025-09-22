package com.github.tdz93.mongodemo.service;

import com.github.tdz93.mongodemo.entity.Product;
import com.github.tdz93.mongodemo.repository.CategoryRepository;
import com.github.tdz93.mongodemo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public String save(Product product) {
        if (product.getCategory() != null) {
            String categoryId = product.getCategory().getId();
            if (!categoryRepository.existsById(categoryId)) {
                throw new IllegalArgumentException("Category with id " + categoryId + " not found");
            }
        }
        return repository.save(product).getId();
    }

    public Product findById(String id) {
        return repository.findById(id)
                .orElse(null);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return repository.findByName(name);
    }

    public List<Product> findByNameStartingWith(String name) {
        return repository.findByNameStartingWith(name);
    }

    public List<Product> findByNameEndingWith(String name) {
        return repository.findByNameEndingWith(name);
    }

    public List<Product> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }

    public List<Product> findByPriceLte(BigDecimal price) {
        return repository.findByPriceLte(price);
    }

    public List<Product> findByPriceGte(BigDecimal price) {
        return repository.findByPriceGte(price);
    }

    public List<Product> sortByFieldAsc(String field, int page) {
        return repository.sortByFieldAsc(field, page);
    }

    public List<Product> sortByFieldDesc(String field, int page) {
        return repository.sortByFieldDesc(field, page);
    }

}
