package com.logistic.demo.io.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document
@Getter
@Setter
@NoArgsConstructor
public class Product {
	@Id
	private String id;
	private String productId;
	private String name;
	private float price;
	private String curraucy;
	//private String category;
}
