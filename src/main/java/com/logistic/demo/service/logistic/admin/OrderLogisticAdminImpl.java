package com.logistic.demo.service.logistic.admin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.Generators;
import com.logistic.demo.io.document.logistic.Region;
import com.logistic.demo.io.document.logistic.SalesMan;
import com.logistic.demo.io.repo.logistic.RegionRepo;
import com.logistic.demo.shared.dto.OrderDTO;
import com.logistic.demo.shared.dto.logistic.admin.RegionAdminDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderLogisticAdminImpl implements OrderLogisiticAdmin {

	private ModelMapper modelMapper = new ModelMapper();
	@Autowired
	private RegionRepo regionRepo;

	@Override
	public Mono<RegionAdminDTO> creatRegion(RegionAdminDTO regionAdminDTO) {
		String regionId = Generators.timeBasedGenerator().generate().toString();
		regionAdminDTO.setRegionId(regionId);
		// regionAdminDTO.setSalesMenDTO(new ArrayList<>());
		Region region = modelMapper.map(regionAdminDTO, Region.class);
		region.setAviliableDates(new HashMap<String, HashSet<SalesMan>>());
//		region.setAviliableDatesMeduim(new HashMap<String, LinkedList<SalesMan>>());
//		region.setAviliableDatesLight(new HashMap<String, LinkedList<SalesMan>>());
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

	@Override
	public Mono<RegionAdminDTO> updateTimeSlots(String regionId, int duration) {
		// TODO Auto-generated method stub
		// the algorithm nedded to update time slots for given region
		// controlled by the region admin
		return this.update(regionId, duration).map(c -> modelMapper.map(c, RegionAdminDTO.class));
	}

	private Mono<RegionAdminDTO> update(String regionId, int duration) {
		// TODO Auto-generated method stub
		return this.regionRepo.findByRegionId(regionId).map(r -> {
			LocalTime midnight = LocalTime.MIDNIGHT;
			LocalDate today = LocalDate.now();
			LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
			LocalDateTime ref = todayMidnight.plusHours(10);
			// if (r.getAviliableDates().isEmpty()) {
			HashSet<SalesMan> salesMen = r.getSalesMen();
			// categorize sales men
//			LinkedList<SalesMan> salesMenH = new LinkedList<>();
//			LinkedList<SalesMan> salesMenM = new LinkedList<>();
//			LinkedList<SalesMan> salesMenL = new LinkedList<>();
//
//			for (SalesMan s : salesMen) {
//				switch (s.getType()) {
//				case "light":
//					salesMenL.add(s);
//				case "heavy":
//					salesMenH.add(s);
//				case "Meduim":
//					salesMenM.add(s);
//
//				}
//
//			}
			Map<String, HashSet<SalesMan>> aviliableDates = r.getAviliableDates();
//			Map<String, LinkedList<SalesMan>> aviliableDatesM = r.getAviliableDatesMeduim();
//			Map<String, LinkedList<SalesMan>> aviliableDatesL = r.getAviliableDatesLight();
			for (int i = 0; i < duration; i++) {
				for (int j = 0; j < 4; j++) {
//					aviliableDatesH.putIfAbsent(ref.toString(), salesMenH);
//					aviliableDatesM.putIfAbsent(ref.toString(), salesMenM);
//					aviliableDatesL.putIfAbsent(ref.toString(), salesMenL);
					aviliableDates.putIfAbsent(ref.toString(), salesMen);
					ref = ref.plusHours(2);
				}
				ref = todayMidnight.plusHours(10);
				ref = ref.plusDays(i + 1);
			}
			return r;
		}).flatMap(r -> this.regionRepo.save(r)).map(c -> modelMapper.map(c, RegionAdminDTO.class));
	}

}
