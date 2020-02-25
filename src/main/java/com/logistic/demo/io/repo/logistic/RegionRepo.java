package com.logistic.demo.io.repo.logistic;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.logistic.demo.io.document.logistic.Region;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RegionRepo extends ReactiveMongoRepository<Region, String> {
	Mono<Region> findByRegionId(String ClientId);
	@Query(value="{}", fields="{name : 1, regionId : 1}")
	Flux<Region> findNameAndregionId();
}
