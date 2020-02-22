package com.logistic.demo.io.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.logistic.demo.io.domain.Vendor;

import reactor.core.publisher.Mono;

public interface VendorRepo extends ReactiveMongoRepository<Vendor,String>{
	Mono<Vendor> findByVendorId(String VendorId);
}