package com.logistic.demo.io.repo.logistic;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.logistic.demo.io.document.logistic.Order;

public interface OrderRepo extends ReactiveMongoRepository<Order,String>{
	

}