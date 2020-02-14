package com.logistic.demo.service.Vendor;

import com.logistic.demo.shared.dto.VendorDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VendorSevice {
	Mono<VendorDTO> creatVendor();
	Flux<VendorDTO> getVendors();
}
