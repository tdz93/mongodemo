package com.github.tdz93.mongodemo.repository;

import com.github.tdz93.mongodemo.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepositoryCustom{

    private final MongoTemplate template;

    @Override
    public List<Product> findByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return template.find(query, Product.class);
    }

    @Override
    public List<Product> findByNameStartingWith(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex("^" + name));
        return template.find(query, Product.class);
    }

    @Override
    public List<Product> findByNameEndingWith(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(name + "$"));
        return template.find(query, Product.class);
    }

    @Override
    public List<Product> findByNameContaining(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(".*" + name + ".*"));
        return template.find(query, Product.class);
    }

    @Override
    public List<Product> findByPriceLte(BigDecimal price) {
        Query query = new Query();
        query.addCriteria(Criteria.where("price").lte(price));
        return template.find(query, Product.class);
    }

    @Override
    public List<Product> findByPriceGte(BigDecimal price) {
        Query query = new Query();
        query.addCriteria(Criteria.where("price").gte(price));
        return template.find(query, Product.class);
    }

    @Override
    public List<Product> sortByFieldAsc(String field, int page) {
        Query query = new Query();
        Pageable pageable = PageRequest.of(page, 2, Sort.by(Sort.Direction.ASC, field));
        query.with(pageable);
        return template.find(query, Product.class);
    }

    @Override
    public List<Product> sortByFieldDesc(String field, int page) {
        Query query = new Query();
        Pageable pageable = PageRequest.of(page, 2, Sort.by(Sort.Direction.DESC, field));
        query.with(pageable);
        return template.find(query, Product.class);
    }
}
