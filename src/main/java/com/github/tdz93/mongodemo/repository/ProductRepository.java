package com.github.tdz93.mongodemo.repository;

import com.github.tdz93.mongodemo.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>, ProductRepositoryCustom {
}
