package com.logistic.demo.service.logistic.Client;

import java.util.HashSet;
import java.util.Map.Entry;

import org.apache.commons.lang3.Range;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistic.demo.io.document.logistic.Order;
import com.logistic.demo.io.document.logistic.SalesMan;
import com.logistic.demo.io.repo.logistic.RegionRepo;
import com.logistic.demo.shared.dto.OrderDTO;
import com.logistic.demo.shared.dto.logistic.client.RegionClientDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderLogisticClientImpl implements OrderLogisticClient {
	private final static ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private RegionRepo regionRepo;

	@Override
	public Flux<RegionClientDTO> getRegions() {
		return regionRepo.findNameAndregionId().map(r -> modelMapper.map(r, RegionClientDTO.class));
	}

	@SuppressWarnings("null")
	@Override
	public Mono<RegionClientDTO> appiontment(String regionId, int size) {
		return this.regionRepo.findByRegionId(regionId).map(r -> {
			RegionClientDTO regionClientDTO = new RegionClientDTO();
			regionClientDTO.setRegionId(r.getRegionId());
			regionClientDTO.setRegionId(r.getRegionId());
			// Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (Entry<String, HashSet<SalesMan>> entry : r.getAviliableDates().entrySet()) {
				// System.out.println("Key = " + entry.getKey() + ", Value = " +
				// entry.getValue());
				for (SalesMan s : entry.getValue()) {
					if (this.sizeinrange(size, s.getAvliablecapacity())) {
						regionClientDTO.getAviliableDates().putIfAbsent(entry.getKey(), s.getName());
					}
				}
			}
			// regionClientDTO.setAviliableDates(temp);
			return regionClientDTO;
		});
	}

	private boolean sizeinrange(int size, int avalibleCapacity) {
		Range<Integer> myRange = Range.between(size-1,size*2);
		if (myRange.contains(avalibleCapacity))
				return true;
		return false;
		/*if (size <= avalibleCapacity && size * 3 > avalibleCapacity) {
			return true;
		}

		if (size == avalibleCapacity)
			return true;

		return false;/**/
	}

	@Override
	public void selectTimeSlot(OrderDTO orderDTO) {
		this.regionRepo.findByRegionId(orderDTO.getRegionId()).map(r -> {
			// HashSet<SalesMan> s =
			// r.getAviliableDates().get(orderDTO.getTimeSlot().toString());
			// s.forEach();
			for (SalesMan s : r.getSalesMen()) {
				if (s.getName() == orderDTO.getSalesManName()) {
					if (this.sizeinrange(orderDTO.getProduct().getSize(), s.getAvliablecapacity())) {
						s.getOredrs().add(modelMapper.map(orderDTO, Order.class));
						int avliablecapacity = s.getAvliablecapacity() - orderDTO.getProduct().getSize();
						s.setAvliablecapacity(avliablecapacity);
					}
				}
			}
			return r;
		}).flatMap(r -> this.regionRepo.save(r));
	}

}
