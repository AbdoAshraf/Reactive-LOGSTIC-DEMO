package com.logistic.demo.shared.dto.logistic.admin;

import java.util.HashMap;
import java.util.Map;

import com.logistic.demo.io.document.logistic.Status;
import com.logistic.demo.shared.dto.OrderDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesManDTO {
	//private String salesManId;
	private String name;
	Map<String,OrderDTO> orders;
	//private int unitcapacity;
	private int avliablecapacity;
	Map<String,Integer> avaliableDates;
	private Status status;
	public SalesManDTO() {
		this.orders = new HashMap<>();
		this.avaliableDates=new HashMap<>();
	}
}
