package com.logistic.demo.service.logistic.Client;

import com.logistic.demo.shared.dto.OrderDTO;
import com.logistic.demo.shared.dto.logistic.client.RegionClientDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderLogisticClient {
	Flux<RegionClientDTO> getRegions();

	Mono<RegionClientDTO> appiontment(String regionId, int size);

	Mono<OrderDTO> selectTimeSlot(OrderDTO orderDTO);
}
