package com.github.tdz93.mongodemo.repository;

import com.github.tdz93.mongodemo.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String>, ProductRepositoryCustom {

    List<Product> findAllByNameContainingIgnoreCase(String name);
    List<Product> findAllByPriceLessThanEqual(BigDecimal price);
    List<Product> findAllByPriceGreaterThanEqual(BigDecimal price);

}
