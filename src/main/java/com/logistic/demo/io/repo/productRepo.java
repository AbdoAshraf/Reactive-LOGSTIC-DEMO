package com.logistic.demo.io.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.logistic.demo.io.document.Product;

public interface productRepo extends ReactiveMongoRepository<Product,String>{
}