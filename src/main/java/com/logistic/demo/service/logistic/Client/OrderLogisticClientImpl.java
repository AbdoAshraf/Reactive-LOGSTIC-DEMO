package com.logistic.demo.service.logistic.Client;

import java.time.LocalDateTime;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import com.logistic.demo.shared.dto.OrderDTO;
import com.logistic.demo.shared.dto.logistic.admin.RegionAdminDTO;
import com.logistic.demo.shared.dto.logistic.client.RegionClientDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OrderLogisticClientImpl implements OrderLogisticClient {

	@Override
	public Flux<RegionClientDTO> getRegions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<LocalDateTime> appiontment(String regionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<OrderDto> selectTimeSlot(LocalDateTime timeSlot, String regionId, String ClientId, String productId) {
		// TODO Auto-generated method stub
		return null;
	}



}
