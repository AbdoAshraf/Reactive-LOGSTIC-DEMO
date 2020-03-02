package com.logistic.demo.service.logistic.admin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map.Entry;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.Generators;
import com.logistic.demo.io.document.logistic.Region;
import com.logistic.demo.io.document.logistic.SalesMan;
import com.logistic.demo.io.repo.logistic.RegionRepo;
import com.logistic.demo.shared.dto.logistic.admin.RegionAdminDTO;
import com.logistic.demo.shared.dto.logistic.admin.SalesManDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderLogisticAdminImpl implements OrderLogisiticAdmin {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private RegionRepo regionRepo;

	@Override
	public Mono<RegionAdminDTO> creatRegion(RegionAdminDTO regionAdminDTO) {
		String regionId = Generators.timeBasedGenerator().generate().toString();
		regionAdminDTO.setRegionId(regionId);
		Region region = modelMapper.map(regionAdminDTO, Region.class);
		return regionRepo.save(region).map(c -> modelMapper.map(c, RegionAdminDTO.class));
	}

	@Override
	public Flux<RegionAdminDTO> getAllRegions() {
		return regionRepo.findAll().map(c -> modelMapper.map(c, RegionAdminDTO.class));/**/
	}

	@Override
	public Mono<RegionAdminDTO> getRegion(String regionId) {
		return this.regionRepo.findByRegionId(regionId).map(c -> modelMapper.map(c, RegionAdminDTO.class));
	}

	@Override
	public Mono<RegionAdminDTO> addSalesMan(String regionId, SalesManDTO salesManDTO) {
		return this.regionRepo.findByRegionId(regionId).map(r -> {
			r.getSalesMen().putIfAbsent(salesManDTO.getName(), modelMapper.map(salesManDTO, SalesMan.class));
			return r;
		}).flatMap(r -> this.regionRepo.save(r).map(c -> modelMapper.map(c, RegionAdminDTO.class)));
	}

//	@Override
//	public Mono<RegionAdminDTO> updateTimeSlots(String regionId, int duration) {
//		// TODO Auto-generated method stub
//		// the algorithm nedded to update time slots for given region
//		// controlled by the region admin
//		return this.updateAll(regionId, duration).map(c -> modelMapper.map(c, RegionAdminDTO.class));
//	}

	@Override
	public Mono<RegionAdminDTO> updateAll(String regionId, int duration) {
		return this.regionRepo.findByRegionId(regionId).map(r -> {

			for (Entry<String, SalesMan> entry : r.getSalesMen().entrySet()) {
				SalesMan m = entry.getValue();
				LocalTime midnight = LocalTime.MIDNIGHT;
				LocalDate today = LocalDate.now();
				LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
				LocalDateTime ref = todayMidnight.plusHours(10);
				for (int i = 0; i < duration; i++) {
					for (int j = 0; j < 4; j++) {
						m.getAvaliableDates().putIfAbsent(ref.toString(), m.getAvliablecapacity());
						ref = ref.plusHours(2);
					}
					ref = todayMidnight.plusHours(10);
					ref = ref.plusDays(i + 1);
				}
			}
			return r;
		}).flatMap(r -> this.regionRepo.save(r)).map(c -> modelMapper.map(c, RegionAdminDTO.class));
	}
}
