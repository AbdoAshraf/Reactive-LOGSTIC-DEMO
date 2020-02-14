package com.logistic.demo.io.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.logistic.demo.io.domain.Client;

public interface ClientRepo extends ReactiveMongoRepository<Client,String>{
	

}


/*
public interface OrderRepo extends ReactiveMongoRepository<Order,String>{
	

}


/**/	





