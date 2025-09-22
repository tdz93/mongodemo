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

    public List<Product> findByNameContaining(String name) {
        return repository.findAllByNameContainingIgnoreCase(name);
    }

    public List<Product> findByPriceLte(BigDecimal price) {
        return repository.findAllByPriceLessThanEqual(price);
    }

    public List<Product> findByPriceGte(BigDecimal price) {
        return repository.findAllByPriceGreaterThanEqual(price);
    }

    public List<Product> sortByFieldAsc(String field, int page, int size) {
        return repository.sortByFieldAsc(field, page, size);
    }

    public List<Product> sortByFieldDesc(String field, int page, int size) {
        return repository.sortByFieldDesc(field, page, size);
    }

}
