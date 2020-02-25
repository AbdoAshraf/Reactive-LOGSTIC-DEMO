package com.logistic.demo.shared.dto.logistic.admin;

import java.util.List;

import com.logistic.demo.shared.dto.OrderDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesManDTO {
	//private String salesManId;
	private String name;
	private int unitcapacity;
	private int avliablecapacity;
	List<OrderDTO> oredrsDTO;
}
