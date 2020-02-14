package com.logistic.demo.service.Vendor;

import com.logistic.demo.shared.dto.ClientDTO;
import com.logistic.demo.shared.dto.VendorDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VendorSevice {
	//Mono<VendorDTO> creatVendor();
	Mono<VendorDTO> updateVendor();
	Flux<VendorDTO> getVendors();
	Mono<VendorDTO> creatVendor(VendorDTO vendorDTO);
	Mono<VendorDTO> getVendor(String vendorId);
}