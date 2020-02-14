package com.logistic.demo.io.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.logistic.demo.io.domain.Vendor;

public interface VendorRepo extends ReactiveMongoRepository<Vendor,String>{
	

}