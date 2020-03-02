package com.logistic.demo.service.logistic.Client;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.Range;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.uuid.Generators;
import com.logistic.demo.exceptions.GlobalException;
import com.logistic.demo.io.document.logistic.Order;
import com.logistic.demo.io.document.logistic.SalesMan;
import com.logistic.demo.io.repo.logistic.RegionRepo;
import com.logistic.demo.service.Vendor.VendorSeviceImpl;
import com.logistic.demo.service.logistic.admin.OrderLogisiticAdmin;
import com.logistic.demo.shared.dto.OrderDTO;
import com.logistic.demo.shared.dto.logistic.client.RegionClientDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderLogisticClientImpl implements OrderLogisticClient {
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RegionRepo regionRepo;
	@Autowired
	OrderLogisiticAdmin orderLogisiticAdmin;

	@Autowired
	private VendorSeviceImpl vendorServicesImpl;

	@Override
	public Flux<RegionClientDTO> getRegions() {
		return regionRepo.findNameAndregionId().map(r -> modelMapper.map(r, RegionClientDTO.class));
	}

	@Override
	public Mono<RegionClientDTO> appiontment(String regionId, int size) {
		return this.regionRepo.findByRegionId(regionId).map(r -> {
			RegionClientDTO regionClientDTO = new RegionClientDTO();
			regionClientDTO.setName(r.getName());
			regionClientDTO.setRegionId(r.getRegionId());
			for (Entry<String, SalesMan> entry : r.getSalesMen().entrySet()) {
				Map<String, Integer> dates = entry.getValue().getAvaliableDates();
				for (Entry<String, Integer> entry1 : dates.entrySet()) {
					if (this.sizeinrange(size, entry1.getValue())) {
						regionClientDTO.getAvalibleDates().put(entry1.getKey(), entry.getKey());
					}
				}

			}
			return regionClientDTO;
		});
	}

	private boolean sizeinrange(int size, int avalibleCapacity) {
		return Range.between(size - 1, size * 2).contains(avalibleCapacity) ? true : false;
	}

	@Override
	public Mono<OrderDTO> selectTimeSlot(OrderDTO orderDTO) {
		return this.vendorServicesImpl.getProduct(orderDTO.getProduct().getVendorId(),
				orderDTO.getProduct().getCategorName(), orderDTO.getProduct().getName()).doOnError((error) -> {
					throw (GlobalException) error;
				}).then(this.regionRepo.findByRegionId(orderDTO.getRegionId()).map(r -> {
					if (!r.getSalesMen().containsKey(orderDTO.getSalesManName()))
						throw new GlobalException(HttpStatus.NOT_FOUND, "sales man not found");
					if (!r.getSalesMen().get(orderDTO.getSalesManName()).getAvaliableDates()
							.containsKey(orderDTO.getTimeSlot().toString()))
						throw new GlobalException(HttpStatus.NOT_FOUND, "no such time slot");
					orderDTO.setOrderId(Generators.timeBasedGenerator().generate().toString());
					SalesMan s = r.getSalesMen().get(orderDTO.getSalesManName());
					int cap = s.getAvaliableDates().get(orderDTO.getTimeSlot().toString());
					if (this.sizeinrange(orderDTO.getProduct().getSize(), cap)) {
						s.getAvaliableDates().replace(orderDTO.getTimeSlot().toString(),
								cap - orderDTO.getProduct().getSize());
						r.getSalesMen().get(orderDTO.getSalesManName()).getOrders().put(orderDTO.getClientId(),
								this.modelMapper.map(orderDTO, Order.class));
					}
					return r;
				}).flatMap(r -> this.regionRepo.save(r)).map(r -> {
					return orderDTO;
				})

		);

	}

}
