package com.logistic.demo.io.repo.logistic;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;

import com.logistic.demo.io.document.logistic.Region;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RegionRepo extends ReactiveMongoRepository<Region, String> {
	Mono<Region> findByRegionId(String ClientId);

	@Query(value = "{}", fields = "{name : 1, regionId : 1}")
	Flux<Region> findNameAndregionId();

	/*@Query(value = "{ 'regionId' : ?0, 'salesMen.name' : ?1 }", fields = "{ 'salesMen.name' : 1 }")
	Mono<Region> findByRegionIdAndSalesMenName(@Param("regionId") String regionId,@Param("salesMen.name") String name);//(String regionId, String name);
/**/
}
