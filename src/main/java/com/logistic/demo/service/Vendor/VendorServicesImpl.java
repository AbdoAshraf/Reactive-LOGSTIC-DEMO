package com.logistic.demo.service.Vendor;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.Generators;
import com.logistic.demo.io.document.Category;
import com.logistic.demo.io.document.Product;
import com.logistic.demo.io.document.Vendor;
import com.logistic.demo.io.repo.VendorRepo;
import com.logistic.demo.shared.dto.CategoryDTO;
import com.logistic.demo.shared.dto.ProductDTO;
import com.logistic.demo.shared.dto.VendorDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VendorServicesImpl implements VendorSevice {
	@Autowired
	private VendorRepo vendorRepo;
	//private final MongoTemplate mongoTemplate;
	

	@Override
	public Mono<VendorDTO> creatVendor(VendorDTO vendorDTO) {
		String vendorId = Generators.timeBasedGenerator().generate().toString();
		vendorDTO.setVendorId(vendorId);
		vendorDTO.setCategories(new ArrayList<>());
		ModelMapper modelMapper = new ModelMapper();
		Vendor vendor = modelMapper.map(vendorDTO, Vendor.class);
		return vendorRepo.save(vendor).map(c -> modelMapper.map(c, VendorDTO.class));

	}

	@Override
	public Mono<VendorDTO> addCateogry(String vendorId, CategoryDTO categoryDTO) {
		String categoryId = Generators.timeBasedGenerator().generate().toString();
		categoryDTO.setCategorytId(categoryId);
		categoryDTO.setProducts(new ArrayList<>());
		return this.vendorRepo.findByVendorId(vendorId).map(v -> {
			v.getCategories().add(new ModelMapper().map(categoryDTO, Category.class));
			return v;
		}).flatMap(v -> vendorRepo.save(v).map(c -> new ModelMapper().map(c, VendorDTO.class)));
	}

	@Override
	public Mono<VendorDTO> addProduct(String vendorId, String CategoryId, ProductDTO producDTO) {
		String productId = Generators.timeBasedGenerator().generate().toString();
		producDTO.setProductId(productId);
		return vendorRepo.findByVendorId(vendorId).map(v -> {
			v.getCategories().forEach(c -> {
				if (c.getCategorytId().equals(CategoryId)) {
					c.getProducts().add(new ModelMapper().map(producDTO, Product.class));
				}
			});
			return v;
		}).flatMap(v -> vendorRepo.save(v).map(c -> new ModelMapper().map(c, VendorDTO.class)));
	}

	@Override
	public Mono<VendorDTO> updateVendor(String vendorID, VendorDTO vendorDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Vendor vendor = modelMapper.map(vendorDTO, Vendor.class);
		return null;
	}

	@Override
	public Flux<VendorDTO> getVendors() {
		ModelMapper modelMapper = new ModelMapper();
		return vendorRepo.findAll().map(c -> modelMapper.map(c, VendorDTO.class));/**/
	}

	@Override
	public Mono<VendorDTO> getVendor(String vendorId) {
		ModelMapper modelMapper = new ModelMapper();
		return vendorRepo.findByVendorId(vendorId).map(c -> modelMapper.map(c, VendorDTO.class));
	}/**/
}
