package com.logistic.demo.service.logistic.admin;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.uuid.Generators;
import com.logistic.demo.io.document.logistic.Region;
import com.logistic.demo.io.repo.logistic.RegionRepo;
import com.logistic.demo.shared.dto.OrderDTO;
import com.logistic.demo.shared.dto.logistic.admin.RegionAdminDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OrderLogisticAdminImpl implements OrderLogisiticAdmin {

	private ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private RegionRepo regionRepo;

	@Override
	public Mono<RegionAdminDTO> creatRegion(RegionAdminDTO regionAdminDTO) {
		String regionId = Generators.timeBasedGenerator().generate().toString();
		regionAdminDTO.setRegionId(regionId);
		regionAdminDTO.setSalesMenDTO(new ArrayList<>());
		Region region = modelMapper.map(regionAdminDTO, Region.class);
		return regionRepo.save(region).map(c -> modelMapper.map(c, RegionAdminDTO.class));
	}

	@Override
	public Mono<RegionAdminDTO> updateRegion(RegionAdminDTO regionAdminDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<RegionAdminDTO> getAllRegions() {
		return regionRepo.findAll().map(c -> modelMapper.map(c, RegionAdminDTO.class));/**/
	}

	@Override
	public Mono<RegionAdminDTO> updateOrder(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<RegionAdminDTO> delteOrder(OrderDTO orderDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
