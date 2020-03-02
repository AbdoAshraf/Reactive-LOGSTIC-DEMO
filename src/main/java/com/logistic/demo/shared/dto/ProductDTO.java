package com.logistic.demo.shared.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
	private String name;
	private String vendorId;
	private String categorName;
	private float price;
	private String curraucy;
	private int size;
	// private String category;
}
