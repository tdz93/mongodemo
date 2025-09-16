package com.github.tdz93.mongodemo.repository;

import com.github.tdz93.mongodemo.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}
