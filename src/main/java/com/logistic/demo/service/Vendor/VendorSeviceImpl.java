package com.logistic.demo.service.Vendor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.Generators;
import com.logistic.demo.exceptions.GlobalException;
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
public class VendorSeviceImpl implements VendorSevice {
	@Autowired
	private VendorRepo vendorRepo;
	// private final MongoTemplate mongoTemplate;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public Mono<VendorDTO> creatVendor(VendorDTO vendorDTO) {
		String vendorId = Generators.timeBasedGenerator().generate().toString();
		vendorDTO.setVendorId(vendorId);
		Vendor vendor = modelMapper.map(vendorDTO, Vendor.class);
		return vendorRepo.save(vendor).map(c -> modelMapper.map(c, VendorDTO.class));
	}

	@Override
	public Mono<VendorDTO> addCateogry(String vendorId, CategoryDTO categoryDTO) {
		// categoryDTO.setProducts(new ArrayList<>());
		return this.vendorRepo.findByVendorId(vendorId).map(v -> {
			// String categoryId = Generators.timeBasedGenerator().generate().toString();
			v.getCategoryMap().putIfAbsent(categoryDTO.getName(), modelMapper.map(categoryDTO, Category.class));
			return v;
		}).flatMap(v -> vendorRepo.save(v).map(c -> modelMapper.map(c, VendorDTO.class)));
	}

	@Override
	public Mono<VendorDTO> addProduct(String vendorId, String categoryName, ProductDTO productDTO) {
		return vendorRepo.findByVendorId(vendorId).map(v -> {
			v.getCategoryMap().get(categoryName).getProductMap().putIfAbsent(productDTO.getName(),
					modelMapper.map(productDTO, Product.class));
			return v;
		}).flatMap(v -> vendorRepo.save(v).map(c -> modelMapper.map(c, VendorDTO.class)));
	}

	@Override
	public Mono<VendorDTO> updateVendor(String vendorID, VendorDTO vendorDTO) {
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

	@Override
	public Mono<ProductDTO> getProduct(String vendorId, String categoryName, String ProductId) {
		return this.getVendor(vendorId).map(r -> {
			if (r.getCategoryMap().containsKey(categoryName)
					&& r.getCategoryMap().get(categoryName).getProductMap().containsKey(ProductId)) {
				Product product = r.getCategoryMap().get(categoryName).getProductMap().get(ProductId);
				return this.modelMapper.map(product, ProductDTO.class);
			}
			throw new GlobalException(HttpStatus.NOT_FOUND, "The data you seek is not here.");
		});
	}
}
