package com.logistic.demo.service.Vendor;

import com.logistic.demo.io.document.Product;
import com.logistic.demo.shared.dto.CategoryDTO;
import com.logistic.demo.shared.dto.ClientDTO;
import com.logistic.demo.shared.dto.ProductDTO;
import com.logistic.demo.shared.dto.VendorDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface VendorSevice {
	//Mono<VendorDTO> creatVendor();
	Flux<VendorDTO> getVendors();
	Mono<VendorDTO> creatVendor(VendorDTO vendorDTO);
	Mono<VendorDTO> getVendor(String vendorId);
	Mono<VendorDTO> updateVendor(String vendorID, VendorDTO vendordto);
	Mono<VendorDTO> addCateogry(String VendorID, CategoryDTO categoryDTO);
	Mono<VendorDTO> addProduct(String vendorId, String categoryId, ProductDTO producDTO);
	Mono<ProductDTO> getProduct(String vendorId, String CategoryId, String ProductId);
}