package com.logistic.demo.io.document.logistic;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class SalesMan {
	@Id
	private String Id;
	private String salesManId;
	private String name;
	List<Order> oredrs;
	//List<LocalDateTime> reservedDates;
}
