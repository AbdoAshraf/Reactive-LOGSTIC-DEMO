package com.logistic.demo.io.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Order {
	@Id
	private String id;
	private String OrderId;
	private Product product;
	private String adress;
}
