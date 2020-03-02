package com.logistic.demo.io.document.logistic;

import java.util.Map;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalesMan {
	@Id
	private String Id;
	private String salesManId;
	private String name;
	private SalesManTimingInfos salesManTimingInfos;
	private int avliablecapacity;
	private Map<String, Order> orders;
	private Map<String, Integer> avaliableDates;
	private Status status;
}
