package com.logistic.demo.io.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.logistic.demo.io.domain.Client;

import reactor.core.publisher.Mono;

public interface ClientRepo extends ReactiveMongoRepository<Client,String>{
	Mono<Client> findByClientId(String ClientId);
}


/*
public interface OrderRepo extends ReactiveMongoRepository<Order,String>{
	

}


/**/	





