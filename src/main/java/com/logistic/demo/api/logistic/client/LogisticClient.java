package com.logistic.demo.api.logistic.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.logistic.demo.service.logistic.Client.OrderLogisticClient;
import com.logistic.demo.shared.dto.OrderDTO;
import com.logistic.demo.shared.dto.logistic.client.RegionClientDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/regionClient")
public class LogisticClient {
	@Autowired
	private OrderLogisticClient orderLogisiticClient;

	@PostMapping()
	public @ResponseBody Mono<OrderDTO> selectTimeSlot(@RequestBody OrderDTO orderDTO) {
		return this.orderLogisiticClient.selectTimeSlot(orderDTO);
	}

	@GetMapping()
	public @ResponseBody Flux<RegionClientDTO> getAllRegions() {
		return this.orderLogisiticClient.getRegions();
	}

	@GetMapping(path = "/{regionId}/{size}")
	public @ResponseBody Mono<RegionClientDTO> appiontment(@PathVariable String regionId, @PathVariable int size) {
		return this.orderLogisiticClient.appiontment(regionId, size);
	}
//	
//	@PutMapping()
//	public void selecttimeslot(@RequestBody OrderDTO orderDTO) {
//		this.orderLogisiticClient.selectTimeSlot(orderDTO);
//	}

}
