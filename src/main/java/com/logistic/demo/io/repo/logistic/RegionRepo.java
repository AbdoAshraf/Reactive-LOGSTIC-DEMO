package com.logistic.demo.io.repo.logistic;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.logistic.demo.io.document.logistic.Region;

import reactor.core.publisher.Mono;

public interface RegionRepo extends ReactiveMongoRepository<Region, String> {
	Mono<Region> findByRegionId(String ClientId);
}
