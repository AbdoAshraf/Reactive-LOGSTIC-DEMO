package com.logistic.demo.ui.logistic.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.logistic.demo.service.logistic.admin.OrderLogisiticAdmin;
import com.logistic.demo.shared.dto.logistic.admin.RegionAdminDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/regionAdmin")
public class LogisticAdmin {
	@Autowired
	private OrderLogisiticAdmin orderLogisiticAdmin;

	@PostMapping()
	public @ResponseBody Mono<RegionAdminDTO> creatRegion(@RequestBody RegionAdminDTO regionAdminDTO) {
		return this.orderLogisiticAdmin.creatRegion(regionAdminDTO);
	}

	@GetMapping()
	public @ResponseBody Flux<RegionAdminDTO> getRegions() {
		return this.orderLogisiticAdmin.getAllRegions();
	}

	@PutMapping(path = "/{regionId}/{duration}")
	public @ResponseBody Mono<RegionAdminDTO> updateRegion(@PathVariable String regionId, @PathVariable int duration) {
		return this.orderLogisiticAdmin.updateTimeSlots(regionId, duration);
	}

}
