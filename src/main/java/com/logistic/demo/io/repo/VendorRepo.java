package com.logistic.demo.io.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.logistic.demo.io.document.Vendor;

import reactor.core.publisher.Mono;

public interface VendorRepo extends ReactiveMongoRepository<Vendor, String> {
	Mono<Vendor> findByVendorId(String VendorId);

//	 @Query(value = "{ 'categories.categorytId' : {$all : [?0] }}")
//	    public Mono<Category> findAnyOfTheseValues(String[] arrayValues);

	//@Query(value = "{  'vendorId' : ?0, 'categories.categorytId' : ?1 }", fields = "{ 'categories.categorytId' : 1 }")
	//Mono<Vendor> findByVendorIdCategoriesCategoryId(String vendorId, String categorytId);
}