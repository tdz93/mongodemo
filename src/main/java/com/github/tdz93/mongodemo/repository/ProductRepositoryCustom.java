package com.github.tdz93.mongodemo.repository;

import com.github.tdz93.mongodemo.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> sortByFieldAsc(String field, int page, int size);
    List<Product> sortByFieldDesc(String field, int page, int size);
}
