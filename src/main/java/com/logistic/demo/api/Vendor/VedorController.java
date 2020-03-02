package com.logistic.demo.api.Vendor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.logistic.demo.exceptions.NotFoundException;
import com.logistic.demo.service.Vendor.VendorSevice;
import com.logistic.demo.shared.dto.CategoryDTO;
import com.logistic.demo.shared.dto.ProductDTO;
import com.logistic.demo.shared.dto.VendorDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/vendor")
public class VedorController {
	@Autowired
	private VendorSevice vendorService;

	@PostMapping()
	public @ResponseBody Mono<VendorDTO> addVendor(@RequestBody VendorDTO vendorDTO) {
		return vendorService.creatVendor(vendorDTO);
	}

	@GetMapping()
	public @ResponseBody Flux<VendorDTO> getAllVendors() {
		return vendorService.getVendors();
	}

	@GetMapping(path = "/{vendorId}")
	public @ResponseBody Mono<VendorDTO> getVendor(@PathVariable String vendorId) {
		return vendorService.getVendor(vendorId);
	}

	@PutMapping(path = "/{vendorId}")
	public @ResponseBody Mono<VendorDTO> updateVendor(@PathVariable String vendorId, @RequestBody VendorDTO vendorDTO) {
		return vendorService.updateVendor(vendorId, vendorDTO);
	}
	
	@PutMapping(path = "/add-category/{vendorId}")
	public @ResponseBody Mono<VendorDTO> addCategory(@PathVariable String vendorId, @RequestBody CategoryDTO categoryDTO) {
		return vendorService.addCateogry(vendorId, categoryDTO);
	}
	
	@PutMapping(path = "/add-product/{vendorId}/{categoryId}")
	public @ResponseBody Mono<VendorDTO> addProduct(@PathVariable String vendorId,
			@PathVariable String categoryId ,@RequestBody ProductDTO productDTO) {
		return vendorService.addProduct(vendorId, categoryId, productDTO);
	}
	
	@GetMapping(path = "/get-product/{vendorId}/{categoryId}/{productId}")
	public @ResponseBody Mono<ProductDTO> getVendor(@PathVariable String vendorId,
			@PathVariable String categoryId,@PathVariable String productId) {
		return this.vendorService.getProduct(vendorId, categoryId, productId).
				switchIfEmpty(Mono.error(new NotFoundException("The data you seek is not here.")));
	}
	    
}
