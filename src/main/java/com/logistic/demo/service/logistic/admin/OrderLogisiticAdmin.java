package com.logistic.demo.service.logistic.admin;

import com.logistic.demo.shared.dto.logistic.admin.RegionAdminDTO;
import com.logistic.demo.shared.dto.logistic.admin.SalesManDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderLogisiticAdmin {
	Mono<RegionAdminDTO> creatRegion(RegionAdminDTO regionAdminDTO);

	Flux<RegionAdminDTO> getAllRegions();

	Mono<RegionAdminDTO> getRegion(String regionId);

	Mono<RegionAdminDTO> addSalesMan(String regionId, SalesManDTO salesManDTO);

	Mono<RegionAdminDTO> updateAll(String regionId, int duration);

}
