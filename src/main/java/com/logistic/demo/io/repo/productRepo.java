package com.logistic.demo.io.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.logistic.demo.io.domain.Product;

public interface productRepo extends ReactiveMongoRepository<Product,String>{
}