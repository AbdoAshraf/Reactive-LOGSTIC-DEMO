package com.logistic.demo.service.logistic.admin;

import com.logistic.demo.shared.dto.OrderDTO;
import com.logistic.demo.shared.dto.logistic.admin.RegionAdminDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderLogisiticAdmin {
	Mono<RegionAdminDTO> creatRegion(RegionAdminDTO regionAdminDTO);

	Mono<RegionAdminDTO> updateRegion(RegionAdminDTO regionAdminDTO);

	Flux<RegionAdminDTO> getAllRegions();

	Mono<RegionAdminDTO> updateOrder(OrderDTO orderDTO);
	
	Mono<RegionAdminDTO> delteOrder(OrderDTO orderDTO);

}
