package com.github.tdz93.mongodemo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@Builder
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private List<String> tags;
    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal price;
    @Field(targetType = FieldType.INT64)
    private Long quantity;
    @Field(targetType = FieldType.DOUBLE)
    private Double rating;
    @DBRef
    private Category category;

}
