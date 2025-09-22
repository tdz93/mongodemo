package com.github.tdz93.mongodemo.repository;

import com.github.tdz93.mongodemo.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findByName(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByPriceLte(BigDecimal price);
    List<Product> findByPriceGte(BigDecimal price);
    List<Product> sortByFieldAsc(String field, int page);
    List<Product> sortByFieldDesc(String field, int page);
}
