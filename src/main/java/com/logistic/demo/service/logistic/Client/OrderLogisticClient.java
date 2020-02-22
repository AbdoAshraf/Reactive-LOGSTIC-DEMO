package com.logistic.demo.service.logistic.Client;

import java.time.LocalDateTime;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import com.logistic.demo.shared.dto.OrderDTO;
import com.logistic.demo.shared.dto.logistic.client.RegionClientDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface OrderLogisticClient {
	Flux<RegionClientDTO> getRegions();

	Flux<LocalDateTime> appiontment(String regionId);

	Mono<OrderDto> selectTimeSlot(LocalDateTime timeSlot, String regionId, String ClientId, String productId);
}
