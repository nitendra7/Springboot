package com.example.day4pms.repository;

import com.example.day4pms.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository
        extends MongoRepository<ProductModel,String> {
}
