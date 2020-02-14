package com.logistic.demo.service.Vendor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.Generators;
import com.logistic.demo.io.domain.Vendor;
import com.logistic.demo.io.repo.VendorRepo;
import com.logistic.demo.shared.dto.ClientDTO;
import com.logistic.demo.shared.dto.VendorDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VendorServicesImpl implements VendorSevice {
	@Autowired
    private VendorRepo vendorRepo;
	@Override
	public Mono<VendorDTO> creatVendor(VendorDTO vendorDTO) {
		String timebaseUUID =  Generators.timeBasedGenerator().generate().toString();
		vendorDTO.setVendorId(timebaseUUID);
		ModelMapper modelMapper = new ModelMapper();
		Vendor vendor = modelMapper.map(vendorDTO, Vendor.class);
		return vendorRepo.save(vendor).map(c -> modelMapper.map(c, VendorDTO.class));
	}

	@Override
	public Mono<VendorDTO> updateVendor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<VendorDTO> getVendors() {
		ModelMapper modelMapper = new ModelMapper();
		return vendorRepo.findAll().map(c -> modelMapper.map(c, VendorDTO.class));
	}
	
	@Override
	public Mono<VendorDTO> getVendor(String vendorId) {
		ModelMapper modelMapper = new ModelMapper();
		return vendorRepo.findByVendorId(vendorId).map(c -> modelMapper.map(c, VendorDTO.class));
	}/**/


}
