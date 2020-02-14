package com.logistic.demo.io.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.logistic.demo.io.domain.Order;

public interface OrderRepo extends ReactiveMongoRepository<Order,String>{
	

}