package com.github.tdz93.mongodemo.service;

import com.github.tdz93.mongodemo.entity.Product;
import com.github.tdz93.mongodemo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public String save(Product product) {
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

}
