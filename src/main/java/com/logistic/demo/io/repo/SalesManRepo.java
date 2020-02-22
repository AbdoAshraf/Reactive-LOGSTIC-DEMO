package com.logistic.demo.io.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.logistic.demo.io.document.Client;
import com.logistic.demo.io.document.logistic.SalesMan;

import reactor.core.publisher.Mono;

public interface SalesManRepo  extends ReactiveMongoRepository<SalesMan, String> {
	Mono<Client> findBySalesManId(String ClientId);

}
